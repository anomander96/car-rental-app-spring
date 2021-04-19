package com.lab.app.controller.assembler;

import com.lab.app.controller.OrderController;
import com.lab.app.controller.model.OrderModel;
import com.lab.app.dto.OrderDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

@Component
public class OrderAssembler extends RepresentationModelAssemblerSupport<OrderDto, OrderModel> {

    public OrderAssembler() {
        super(OrderController.class, OrderModel.class);
    }

    @Override
    public OrderModel toModel(OrderDto entity) {
        OrderModel orderModel = new OrderModel(entity);

        Link getOrder = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder
                .methodOn(OrderController.class)
                .getOrder(entity.getOrderId()))
                .withRel("getOrder");

        Link updateOrder = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder
                .methodOn(OrderController.class)
                .updateOrder(entity, entity.getOrderId()))
                .withRel("updateOrder");

        Link deleteOrder = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder
                .methodOn(OrderController.class)
                .deleteOrder(entity.getOrderId()))
                .withRel("deleteOrder");

        orderModel.add(getOrder, updateOrder, deleteOrder);
        return orderModel;
    }
}
