INSERT INTO prenda (id, nombre, marca, color, talle, cantidad, precio_venta) VALUE (1, 'Camisa', 'Levi´s', 'Azul', 'L', 5, 39.99);
INSERT INTO prenda (id, nombre, marca, color, talle, cantidad, precio_venta) VALUE (2, 'Pantalón', 'Nike', 'Negro', 'M', 8, 49.99);
INSERT INTO prenda (id, nombre, marca, color, talle, cantidad, precio_venta) VALUE (3, 'Chaqueta', 'Adidas', 'Gris', 'XL', 3, 79.99);
INSERT INTO ventas (id, fecha, monto_total, metodo_pago) VALUE (1, '2024-02-07', 39.99, 'Efectivo');
INSERT INTO ventas (id, fecha, monto_total, metodo_pago) VALUE (2, '2024-02-07', 89.98, 'Debito');
INSERT INTO ventas_prendas (ventas_id, prendas_id) VALUE (1, 1);
INSERT INTO ventas_prendas (ventas_id, prendas_id) VALUE (2, 1);
INSERT INTO ventas_prendas (ventas_id, prendas_id) VALUE (2, 2);