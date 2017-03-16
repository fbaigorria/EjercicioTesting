
<%@ page import="com.meli.academy.grails.test.Producto" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'producto.label', default: 'Producto')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-producto" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-producto" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="nombre" title="${message(code: 'producto.nombre.label', default: 'Nombre')}" />
					
						<g:sortableColumn property="codigo" title="${message(code: 'producto.codigo.label', default: 'Codigo')}" />
					
						<g:sortableColumn property="imageName" title="${message(code: 'producto.imageName.label', default: 'Image Name')}" />
					
						<g:sortableColumn property="disponible" title="${message(code: 'producto.disponible.label', default: 'Disponible')}" />
					
						<th><g:message code="producto.categoria.label" default="Categoria" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${productoInstanceList}" status="i" var="productoInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${productoInstance.id}">${fieldValue(bean: productoInstance, field: "nombre")}</g:link></td>
					
						<td>${fieldValue(bean: productoInstance, field: "codigo")}</td>
					
						<td>${fieldValue(bean: productoInstance, field: "imageName")}</td>
					
						<td><g:formatBoolean boolean="${productoInstance.disponible}" /></td>
					
						<td>${fieldValue(bean: productoInstance, field: "categoria")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${productoInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>