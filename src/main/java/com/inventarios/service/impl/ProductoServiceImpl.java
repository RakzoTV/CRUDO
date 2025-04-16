package com.inventarios.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventarios.dto.ProductoDTO;
import com.inventarios.model.Categoria;
import com.inventarios.model.Producto;
import com.inventarios.repository.ProductoRepository;
import com.inventarios.service.IProductoService;

@Service
public class ProductoServiceImpl implements IProductoService {

    @Autowired
    private ProductoRepository productoRepository;
    
    @Override
    public List<ProductoDTO> obtenerTodosLosProductos() {
        return productoRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProductoDTO obtenerProductoPorId(Long id) {
        return productoRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    @Override
    public ProductoDTO crearProducto(ProductoDTO productoDTO) {
        Producto producto = convertToEntity(productoDTO);
        Producto nuevoProducto = productoRepository.save(producto);
        return convertToDTO(nuevoProducto);
    }

    @Override
    public ProductoDTO actualizarProducto(Long id, ProductoDTO productoDTO) {
        Producto productoExistente = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        productoExistente.setCodigo(productoDTO.getCodigo());
        productoExistente.setNombre(productoDTO.getNombre());
        productoExistente.setStock_inicial(productoDTO.getStock_inicial());
        productoExistente.setStock_actual(productoDTO.getStock_actual());
        productoExistente.setUmbral_minimo(productoDTO.getUmbral_minimo());

        Categoria categoria = null;
        if(productoDTO.getCategoria() != null){
            categoria = new Categoria();
            categoria.setId(productoDTO.getCategoria());
        }

        productoExistente.setCategoria(categoria);

        Producto productoActualizado = productoRepository.save(productoExistente);
        return convertToDTO(productoActualizado);
    }

    @Override
    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }

    private ProductoDTO convertToDTO(Producto producto) {
        return ProductoDTO.builder()
                .id(producto.getId())
                .codigo(producto.getCodigo())
                .nombre(producto.getNombre())
                .stock_inicial(producto.getStock_inicial())
                .stock_actual(producto.getStock_actual())
                .umbral_minimo(producto.getUmbral_minimo())
                .categoria(producto.getCategoria() != null ? producto.getCategoria().getId() : null)
                .build();
    }

    private Producto convertToEntity(ProductoDTO productoDTO) {
        Categoria categoria = null;
        if(productoDTO.getCategoria() != null){
            categoria = new Categoria();
            categoria.setId(productoDTO.getCategoria()); // Solo asignar el ID
        }
        return Producto.builder()
                .id(productoDTO.getId())
                .codigo(productoDTO.getCodigo())
                .nombre(productoDTO.getNombre())
                .stock_inicial(productoDTO.getStock_inicial())
                .stock_actual(productoDTO.getStock_actual())
                .umbral_minimo(productoDTO.getUmbral_minimo())
                .categoria(categoria)
                .build();
    }
}
