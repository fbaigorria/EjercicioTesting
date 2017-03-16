package com.meli.academy.grails.test

class Categoria {
	
	String nombre
	
	static hasMany = [productos:Producto]

    static constraints = {
		nombre matches: /[A-Z]+[a-z]+/, blank: false
    }
}