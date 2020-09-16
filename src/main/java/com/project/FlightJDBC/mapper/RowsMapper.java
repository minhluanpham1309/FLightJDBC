/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.FlightJDBC.mapper;

import java.sql.ResultSet;

/**
 *
 * @author minhluan
 */
public interface RowsMapper<T> {
    T mapRow(ResultSet rs, int rowNum);
}
