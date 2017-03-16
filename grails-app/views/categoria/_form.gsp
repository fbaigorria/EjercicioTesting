<%@ page import="com.meli.academy.grails.test.Categoria" %>



<div class="fieldcontain ${hasErrors(bean: categoriaInstance, field: 'nombre', 'error')} required">
	<label for="nombre">
		<g:message code="categoria.nombre.label" default="Nombre" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nombre" pattern="${categoriaInstance.constraints.nombre.matches}" required="" value="${categoriaInstance?.nombre}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: categoriaInstance, field: 'productos', 'error')} ">
	<label for="productos">
		<g:message code="categoria.productos.label" default="Productos" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${categoriaInstance?.productos?}" var="p">
    <li><g:link controller="producto" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="producto" action="create" params="['categoria.id': categoriaInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'producto.label', default: 'Producto')])}</g:link>
</li>
</ul>


</div>

