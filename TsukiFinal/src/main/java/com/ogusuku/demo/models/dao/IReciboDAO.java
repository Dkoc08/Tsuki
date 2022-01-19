package com.ogusuku.demo.models.dao;

import org.springframework.data.repository.CrudRepository;


import com.ogusuku.demo.models.entity.Recibo;

public interface IReciboDAO extends CrudRepository<Recibo, Long> {
}
