package com.meli.academy.grails.test

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Producto)
class ProductoSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "Probando constraint Producto"() {
		Categoria cat = new Categoria(nombre: 'Liquido', id: 1)
		
		//ATRIBUTO: nombre
		when: 'El nombre comienza con una letra minuscula'
			def prod = new Producto(nombre: 'bebidas', codigo: 'ret45', imageName: 'fichero09.png', disponible: true, categoria: cat)
		then: 'la validacion no pasa'
			!prod.validate()
			
		when: 'El nombre comienza con una letra mayuscula pero tiene numeros'
			prod = new Producto(nombre: 'bebidas12', codigo: 'ret45', imageName: 'fichero09.png', disponible: true, categoria: cat)
		then: 'la validacion no pasa'
			!prod.validate()
			
		when: 'El nombre comienza con una letra mayuscula pero tiene caracteres especiales'
			prod = new Producto(nombre: 'bebidas_frias', codigo: 'ret45', imageName: 'fichero09.png', disponible: true, categoria: cat)
		then: 'la validacion no pasa'
			!prod.validate()
			
		when: 'El nombre comienza con una letra mayuscula y sigue con letras minusculas'
			prod = new Producto(nombre: "Bebidas", codigo: 'ret45', imageName: 'fichero09.png', disponible: true, categoria: cat)
		then:
			prod.validate()
			
		//ATRIBUTO: codigo
		when: 'El codigo contiene caracteres especiales'
			prod = new Producto(nombre: "Bebidas", codigo: 'ret_45', imageName: 'fichero09.png', disponible: true, categoria: cat)
		then:
			!prod.validate()
			
		when: 'El codigo no contiene caracteres especiales'
			prod = new Producto(nombre: "Bebidas", codigo: 'ret45', imageName: 'fichero09.png', disponible: true, categoria: cat)
		then:
			prod.validate()
		
		//ATRIBUTO: imageName
		when: 'La imagen contiene caracteres especiales en nombre'
			prod = new Producto(nombre: "Bebidas", codigo: 'ret_45', imageName: 'fichero-09.png', disponible: true, categoria: cat)
		then:
			!prod.validate()
		
		when: 'La imagen contiene caracteres especiales en extension'
			prod = new Producto(nombre: "Bebidas", codigo: 'ret_45', imageName: 'fichero09.png-2', disponible: true, categoria: cat)
		then:
			!prod.validate()
			
		when: 'La imagen no contiene punto para extension'
			prod = new Producto(nombre: "Bebidas", codigo: 'ret_45', imageName: 'fichero09png', disponible: true, categoria: cat)
		then:
			!prod.validate()
			
		when: 'La imagen no contiene extension'
			prod = new Producto(nombre: "Bebidas", codigo: 'ret_45', imageName: 'fichero09.', disponible: true, categoria: cat)
		then:
			!prod.validate()
			
		when: 'La imagen contiene letras y numeros, punto para extension, y extension solo con letras'
			prod = new Producto(nombre: "Bebidas", codigo: 'ret45', imageName: 'fichero09.png', disponible: true, categoria: cat)
		then:
			prod.validate()
		
    }
}
