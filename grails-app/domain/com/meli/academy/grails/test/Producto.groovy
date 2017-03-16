package com.meli.academy.grails.test

class Producto {
	
	String nombre
	String codigo
	String imageName
	boolean disponible
	
	static belongsTo = [categoria:Categoria]

    static constraints = {
		nombre matches: /[A-Z][a-z]+/, blank: false
		codigo matches: /[A-Za-z0-9]+/, blank: false
		imageName matches: /[A-Za-z0-9]+[.]+[a-z]+/, blank: false
		disponible nullabe: false, blank: false
    }
}
