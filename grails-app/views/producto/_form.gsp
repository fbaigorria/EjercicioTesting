<%@ page import="com.meli.academy.grails.test.Producto" %>



<div class="fieldcontain ${hasErrors(bean: productoInstance, field: 'nombre', 'error')} required">
	<label for="nombre">
		<g:message code="producto.nombre.label" default="Nombre" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nombre" pattern="${productoInstance.constraints.nombre.matches}" required="" value="${productoInstance?.nombre}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: productoInstance, field: 'codigo', 'error')} required">
	<label for="codigo">
		<g:message code="producto.codigo.label" default="Codigo" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="codigo" pattern="${productoInstance.constraints.codigo.matches}" required="" value="${productoInstance?.codigo}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: productoInstance, field: 'imageName', 'error')} required">
	<label for="imageName">
		<g:message code="producto.imageName.label" default="Image Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="imageName" pattern="${productoInstance.constraints.imageName.matches}" required="" value="${productoInstance?.imageName}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: productoInstance, field: 'disponible', 'error')} ">
	<label for="disponible">
		<g:message code="producto.disponible.label" default="Disponible" />
		
	</label>
	<g:checkBox name="disponible" value="${productoInstance?.disponible}" />

</div>

<div class="fieldcontain ${hasErrors(bean: productoInstance, field: 'categoria', 'error')} required">
	<label for="categoria">
		<g:message code="producto.categoria.label" default="Categoria" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="categoria" name="categoria.id" from="${com.meli.academy.grails.test.Categoria.list()}" optionKey="id" required="" value="${productoInstance?.categoria?.id}" class="many-to-one"/>

</div>

