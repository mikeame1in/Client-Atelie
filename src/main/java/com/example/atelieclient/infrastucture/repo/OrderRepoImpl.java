package com.example.atelieclient.infrastucture.repo;

import com.example.atelieclient.application.port.out.OrderRepo;
import com.example.atelieclient.domain.model.Customer;
import com.example.atelieclient.domain.model.Order;
import javafx.collections.ObservableList;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class OrderRepoImpl implements OrderRepo {
    private List<Order> orders = null;

    private List<Order> getOrders(){
        if (orders == null) {
            orders = new ArrayList<>();

            try {
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

                Date date1 = dateFormat.parse("23/09/2007");
                Order order1 = new Order("Куртка", new Timestamp(date1.getTime()));
                order1.setId(Long.valueOf(1));
                order1.setCustomerId(Long.valueOf(1));

                Date date2 = dateFormat.parse("23/05/2015");
                Order order2 = new Order("Куртка", new Timestamp(date2.getTime()));
                order2.setId(Long.valueOf(2));
                order2.setCustomerId(Long.valueOf(2));

                orders.add(order1);
                orders.add(order2);
            } catch (ParseException e) {
                System.err.println(e);
            }

        }

        return orders;
    }
    @Override
    public void createOrder(Order order) {
        getOrders().add(order);
    }

    @Override
    public void deleteOrder(Order order) {
        getOrders().remove(order);
    }

    @Override
    public List<Order> getAllCustomerOrders(Long customerId) {
        return getOrders().stream().filter(order -> order.getCustomerId().equals(customerId)).collect(Collectors.toList());
    }
}
