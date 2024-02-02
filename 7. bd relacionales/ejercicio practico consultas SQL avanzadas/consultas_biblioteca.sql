-- 1. Listar los datos de los autores.
select * from AUTOR;

-- 2. Listar nombre y edad de los estudiantes
select Nombre, Edad from ESTUDIANTE;

-- 3. ¿Qué estudiantes pertenecen a la carrera informática?
select * from ESTUDIANTE where Carrera = "informatica";

-- 4. ¿Qué autores son de nacionalidad francesa o italiana?
select * from AUTOR where Nacionalidad = "francesa" or Nacionalidad = "italiana";

-- 5. ¿Qué libros no son del área de internet?
select * from LIBRO where Area != "internet";

-- 6. Listar los libros de la editorial Salamandra.
select * from LIBRO where Editorial = "Salamandra";

-- 7. Listar los datos de los estudiantes cuya edad es mayor al promedio.
select * from ESTUDIANTE where Edad > AVG(Edad);

-- 8. Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
select Nombre from ESTUDIANTE where Apellido like "%G";

-- 9. Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
select au.Nombre from AUTOR as au
join LIBROAUTOR as liau on au.idAutor = liau.idAutor
join LIBRO as lib on liau.idLibro = lib.idLibro
where lib.Titulo = "El Universo: Guía de viaje";

-- 10. ¿Qué libros se prestaron al lector “Filippo Galli”? 
select * from LIBRO as lib 
join PRESTAMO as pre on lib.idLibro = pre.idLibro
join ESTUDIANTE as est on pre.idLector = est.idLector
where est.Nombre = "Filippo" and est.Apellido = "Galli";

-- 11. Listar el nombre del estudiante de menor edad.

select nombre from ESTUDIANTE where Edad
in (select MIN(Edad) from ESTUDIANTE); 

-- 12. Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
select est.Nombre from ESTUDIANTE
join PRESTAMO as pre on est.idLector = pre.idLector
join LIBRO as lib on pre.idLibro = lib.idlibro
where lib.Area = "Base de Datos";

-- 13. Listar los libros que pertenecen a la autora J.K. Rowling.
select * from LIBROS as lib 
join LIBROAUTOR as liau on lib.idLibro = liau.idLibro
join AUTOR as aut on liau.idLibro = aut.idAutor
where aut.Nombre = "J.K. Rowling"; 

-- 14. Listar títulos de los libros que debían devolverse el 16/07/2021.
select lib.Titulo from LIBRO as lib
join PRESTAMO as pre on lib.idLibro = pre.idLibro
where pre.FechaDevolucion = "2021-07-16";