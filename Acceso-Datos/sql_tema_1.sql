/*1.Realizar un programa que solicite un número de empleado determinado, el programa
debe comprobar si el salario es mayor que 1000, y si no es así actualizar el 
salario con una subida del 20% y, en una tabla temporal, insertar el nombre del
empleado y el mensaje "Sueldo actualizado". Si ya superaba los 1000, se inserta 
en la tabla temporal el nombre del empleado y el mensaje "No necesita a
ctualización".
RESPUESTA: */


--drop table temp;
CREATE TABLE temp (
    numemple  NUMBER(6),
    mensaje   VARCHAR2(50)
);

DECLARE
    v_salary   employee.salary%TYPE;
    v_emploid  employee.employee_id%TYPE;
BEGIN
    dbms_output.put_line('Enter employee id');
    v_emploid := '&codigo';
    SELECT
        salary
    INTO v_salary
    FROM
        employee
    WHERE
        employee_id = v_emploid;

    IF v_salary <= 1000 THEN
        UPDATE employee
        SET
            salary = v_salary * 1.20
        WHERE
            employee_id = v_emploid;

        INSERT INTO temp (
            numemple,
            mensaje
        ) VALUES (
            v_emploid,
            'Salary increased'
        );

    ELSE
        INSERT INTO temp (
            numemple,
            mensaje
        ) VALUES (
            v_emploid,
            'Salary stays the same'
        );

    END IF;

END;
/

/*
2.Hacer un programa que solicite por teclado un código de cliente e inserte en la 
tabla temporal el número total de pedidos de ese cliente (tot_ped), el precio
total de esos pedidos (precio_tot), el código del cliente (cod_cli) y el 
nombre del cliente (nombre_cli).
RESPUESTA: 
*/

--drop table temp;
--create table temp (CodigoCliente number(6), TotalPedido number(10),PrecioTotal number(10),Nombre varchar2(50));

DECLARE
    cod_cliente     NUMBER(6);
    tot_ped         NUMBER(10);
    precio_tot      NUMBER(10);
    nombre_cliente  VARCHAR2(50);
BEGIN
    cod_cliente := '&codigo';
    
    -- Count the total number of orders for the customer
        SELECT
        COUNT(*)
    INTO tot_ped
    FROM
        sales_order
    WHERE
        customer_id = cod_cliente;

    -- Sum the total price of all orders for the customer
        SELECT
        nvl(SUM(total), 0)
    INTO precio_tot
    FROM
        sales_order
    WHERE
        customer_id = cod_cliente;

    -- Get the name of the customer
        SELECT
        name
    INTO nombre_cliente
    FROM
        customer
    WHERE
        customer_id = cod_cliente;
    
    -- Insert data into temp table
        INSERT INTO temp (
        codigocliente,
        totalpedido,
        preciototal,
        nombre
    ) VALUES (
        cod_cliente,
        tot_ped,
        precio_tot,
        nombre_cliente  -- Remove the trailing comma
        );

END;
/

/*Crearse un registro t_reg_emple con la siguiente estructura: código del empleado
, nombre y el job. Insertar en una tabla temporal el nombre del empleado y job para el empleado 7782.
RESPUESTA: */

--drop table temp;
--create table temp (NombreEmpleado varchar2(20), Funcion varchar2(40));

--CREAMOS UN REGISTRO: 

DECLARE
    TYPE t_reg_emple IS RECORD ( 
        nombre_empleado VARCHAR2(40),
        funcion VARCHAR2(40)
    );

    t_reg t_reg_emple;
    
BEGIN

    SELECT first_name INTO t_reg.nombre_empleado
    FROM employee
    WHERE employee_id = 7499;  -- Assuming employee_id is a number

    SELECT job_id INTO t_reg.funcion
    FROM job
    WHERE job_id = (SELECT job_id
                    FROM employee
                    WHERE employee_id = 7499);  -- Assuming employee_id is a number

    -- Insert data into temp table
    INSERT INTO temp (NombreEmpleado, Funcion)
    VALUES (t_reg.nombre_empleado, t_reg.funcion);

END;
/

select * from temp;


























