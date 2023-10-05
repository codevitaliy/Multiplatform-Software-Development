/*1.Realizar un programa que solicite un número de empleado determinado, el programa
debe comprobar si el salario es mayor que 1000, y si no es así actualizar el 
salario con una subida del 20% y, en una tabla temporal, insertar el nombre del
empleado y el mensaje "Sueldo actualizado". Si ya superaba los 1000, se inserta 
en la tabla temporal el nombre del empleado y el mensaje "No necesita a
ctualización".
RESPUESTA: */


--drop table temp;
--create table temp (numEmple number(6), mensaje varchar2(50));

DECLARE
    v_salary   employee.salary%TYPE;
    v_emploid  employee.employee_id%TYPE;
BEGIN
    dbms_output.put_line('Enter employee id');
    v_emploid:='&codigo';
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











