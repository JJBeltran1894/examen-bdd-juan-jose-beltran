-- PARTE 4

-- 4.2 creación de la tabla intermedia - rompimiento
create table proyectos_tecnologias (
    id_proyecto integer not null,
    id_tecnologia integer not null,
    constraint pk_proyectos_tecnologias primary key(id_proyecto, id_tecnologia),
    constraint fk_proyecto foreign key(id_proyecto) references proyectos(id),
    constraint fk_tecnologia foreign key(id_tecnologia) references tecnologias(id)
);

-- 4.3 consultas relacionales - joins 

-- 1. tecnologías por proyecto - Obtener tecnologías de un proyecto específico
select t.nombre, t.categoria
from tecnologias t
join proyectos_tecnologias pt on t.id = pt.id_tecnologia
join proyectos p on p.id = pt.id_proyecto
where p.nombre = 'nombredelproyecto';

-- 2. proyectos por tecnología - Obtener proyectos que usan una tecnología por id
select p.nombre, p.dias_estimados
from proyectos p
inner join proyectos_tecnologias pt on p.id = pt.id_proyecto
inner join tecnologias t on t.id = pt.id_tecnologia
where t.id = 1; 

-- 3. reporte de uso tecnológico - Contar proyectos por tecnología ordenado de mayor a menor
select t.nombre, count(pt.id_proyecto) as total_proyectos
from tecnologias t
inner join proyectos_tecnologias pt on t.id = pt.id_tecnologia
group by t.nombre
order by total_proyectos desc;