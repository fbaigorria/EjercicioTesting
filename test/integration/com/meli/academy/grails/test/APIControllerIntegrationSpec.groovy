package com.meli.academy.grails.test

import grails.converters.JSON
class APIControllerIntegrationSpec extends GroovyTestCase {

	def cat
	def prod

	def setup() {
		//Creamos categoria y Producto
		cat = new Categoria(nombre: 'Bebidas')
		prod = new Producto(nombre: "Fanta", codigo: 'ret45', imageName: 'fichero09.png', disponible: true, categoria: cat)
		cat.addToProductos(prod)
		cat.save()
		prod.save()
	}

	def cleanup() {
		prod.delete()
		cat.delete()
	}

	void "testJsonCategoriaAndProducto"() {
		//Inicializamos todo lo necesario
		setup()
		
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
		def jsonCat = listaCategorias as JSON
		
		def listaProductos = [productosInstanceList:[Producto.list().sort {it.id}]]
		def jsonProd = listaProductos as JSON

		//Llamamos al controller para que nos devuelva metodos de controller
		APIController controller = new APIController()
		
		controller.jsonProducto()
		assertEquals(jsonProd.toString(), controller.response.contentAsString)
		
		controller.response.reset()
		
		controller.jsonCategoria()

		assertEquals(jsonCat.toString(), controller.response.contentAsString)
		
		println "JSON CATEGORIA:"
		println jsonCat.toString()
		println "JSON CATEGORIA RESPONSE:"
		println controller.response.contentAsString
		
		//Limpiamos
		cleanup()
	}
}
