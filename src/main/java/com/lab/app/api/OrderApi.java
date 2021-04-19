package com.lab.app.api;

import com.lab.app.controller.model.OrderModel;
import com.lab.app.dto.OrderDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "Order management API")
@RequestMapping(value = "/api/v1/orders")
public interface OrderApi {

    @ApiOperation("Getting order from database")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{orderId}")
    OrderModel getOrder(@PathVariable int orderId);

    @ApiOperation("Creating order")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    OrderModel createOrder(@Valid @RequestBody OrderDto orderDto);

    @ApiOperation("Updating order")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{orderId}")
    OrderModel updateOrder(@Valid @RequestBody OrderDto orderDto, @PathVariable int orderId);

    @ApiOperation("Deleting order")
    @DeleteMapping(value = "/{orderId}")
    ResponseEntity<Void> deleteOrder(@PathVariable int orderId);
}
