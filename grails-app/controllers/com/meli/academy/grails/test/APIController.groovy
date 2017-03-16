package com.meli.academy.grails.test

import grails.converters.JSON
import grails.converters.XML
import groovy.json.*

class APIController {
	
	def index(){
		redirect jsonProducto()
	}

    def jsonCategoria = {
		
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
		render listaCategorias as JSON
	}
	
	def jsonProducto = {
		
		JSON.registerObjectMarshaller(Producto) {
			def returnArray = [:]
			returnArray['nombre'] = it.nombre
			returnArray['codigo'] = it.codigo
			returnArray['imagen'] = it.imageName
			returnArray['disponible'] = it.disponible
			return returnArray
		}
		
		def listaProductos = [productosInstanceList:[Producto.list().sort {it.id}]]
		render listaProductos as JSON
	}
}
