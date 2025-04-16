package com.inventarios.service;

import java.util.List;

import com.inventarios.dto.ProductoDTO;


public interface IProductoService {
    List<ProductoDTO> obtenerTodosLosProductos();
    ProductoDTO obtenerProductoPorId(Long id);
    ProductoDTO crearProducto(ProductoDTO productoDTO);
    ProductoDTO actualizarProducto(Long id, ProductoDTO productoDTO);
    void eliminarProducto(Long id);
}
