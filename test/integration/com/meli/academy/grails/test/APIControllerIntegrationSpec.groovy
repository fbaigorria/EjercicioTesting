package com.meli.academy.grails.test
import grails.converters.JSON

import grails.test.spock.IntegrationSpec

class APIControllerIntegrationSpec extends IntegrationSpec {

	def cat
	def prod

	def setup() {
		//Creamos categoria y Producto
		cat = new Categoria(nombre: 'Liquido', id: 1)
		prod = new Producto(nombre: "Bebidas", codigo: 'ret45', imageName: 'fichero09.png', disponible: true, categoria: cat)
		cat.save()
		prod.save()
	}

	def cleanup() {
		prod.delete()
		cat.delete()
	}

	void "Test Json Categoria"() {
		when: 'Obtenemos Json'
		//Creamos un objeto Json
		JSON.registerObjectMarshaller(Producto) {
			def returnArray = [:]
			returnArray['nombre'] = it.nombre
			returnArray['codigo'] = it.codigo
			returnArray['imagen'] = it.imageName
			returnArray['disponible'] = it.disponible
			return returnArray
		}

		JSON.registerObjectMarshaller(Categoria) {
			def returnArray = [:]
			returnArray['nombre'] = it.nombre
			returnArray['productos'] = it.productos
			return returnArray
		}

		def listaCategorias = [categoriasInstanceList:[Categoria.list().sort {it.id}]]
		def json = listaCategorias as JSON

		//Llamamos al controller para que nos devuelva metodos de controller
		APIController controller = new APIController()
		controller.jsonCategoria()
		assertEquals(json.toString(), controller.response.contentAsString)
	}
}
