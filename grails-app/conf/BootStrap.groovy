import com.meli.academy.grails.test.Categoria
import com.meli.academy.grails.test.Producto
import grails.util.Environment

class BootStrap {

    def init = { servletContext ->
		def result = '...'
		println "Iniciando aplicacion ..."
		switch (Environment.current){
			case Environment.DEVELOPMENT:
				result = '... en modo DEV.'
				seedTestData()
				break
			case Environment.TEST:
				result = '... en modo TEST.'
				break
			case Environment.PRODUCTION:
				result = '... en modo PROD.'
				//seedProdData()
				break
		}
		
		println "entorno actual: $Environment.current"
		println "$result"
    }
    def destroy = {
    }
	
	private void seedTestData(){
		if(Categoria.count == 0){
			
			def categoria1 = new Categoria(nombre:'Celulares')
			assert categoria1.save(failOnError:true, flush:true, insert:true)
			categoria1.errors = null
			
			def categoria2 = new Categoria(nombre:'Bebidas')
			assert categoria2.save(failOnError:true, flush:true, insert:true)
			categoria2.errors = null
			
			assert Categoria.count == 2
			println "Se terminaron de cargar $Categoria.count categorias en la base de datos"
			
			
			def producto
			producto = new Producto(nombre: 'Fanta', codigo: 'bebida02', imageName: 'fichero09.png', disponible: true, categoria: categoria2)
			assert producto.save(failOnError:true, flush:true, insert:true)
			producto.errors = null
			
			producto = new Producto(nombre: 'Coca', codigo: 'bebida01', imageName: 'fichero10.png', disponible: true, categoria: categoria2)
			assert producto.save(failOnError:true, flush:true, insert:true)
			producto.errors = null
			
			producto = new Producto(nombre: 'Motorola', codigo: 'cel02', imageName: 'fichero11.png', disponible: true, categoria: categoria1)
			assert producto.save(failOnError:true, flush:true, insert:true)
			producto.errors = null
			
			producto = new Producto(nombre: 'Samsung', codigo: 'cel01', imageName: 'fichero12.png', disponible: true, categoria: categoria1)
			assert producto.save(failOnError:true, flush:true, insert:true)
			producto.errors = null
			
			
			assert Producto.count == 4
			println "Se terminaron de cargar $Producto.count productos en la base de datos"
			
		} else {
			println "Ya hay datos cargados"
		}
	}
}
