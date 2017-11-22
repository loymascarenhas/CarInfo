package com.cardata.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

@Component
@Path("/car")
public class CarRest {
	private Map<Long, Car> cars = new HashMap<Long, Car>();
	private static long id=1;
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addCars(Car[] carArr) {
		// curl -H "Content-Type:application/json" -X POST -d @body.json  http://localhost:8080/cardata/car/add
		for(Car car: carArr) {
			car.setId(id);
			cars.put(id, car);
			id++;
		}
		//201 created
		return Response.ok(carArr.length + " car(s) added").build();
	}
	
	@DELETE
	@Path("/delete/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteCar(@PathParam("id") long id) {
		// curl -X DELETE http://localhost:8080/cardata/car/delete/1
		for(Map.Entry<Long, Car> car:cars.entrySet()) {
			if(car.getKey() == id) {
				cars.remove(id);
				//204 no content
				return Response.ok("Car with id:" + car.getKey() + " deleted").build();
			}
		}
		//return Response.status(Status.NO_CONTENT).build();
		return Response.ok("Car with id:" + id + " does not exist").build();
	}
	
	@GET
	@Path("/get/all")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCars(){
		// curl http://localhost:8080/cardata/car/get/all
		return Response.ok(cars.values()).build();
	}
	
	@GET
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCarById(@PathParam("id") long id) {
		// curl http://localhost:8080/cardata/car/get/1
		for(Map.Entry<Long, Car> car:cars.entrySet()) {
			if(car.getKey() == id) {
				return Response.ok(car.getValue()).build();
			}
		}
		return Response.ok("Car not found").build();
	}
	
	@GET
	@Path("/get/make/{make}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCarByMake(@PathParam("make") String make) {
		List<Car> tempCars = new ArrayList<Car>();
		for(Map.Entry<Long, Car> car:cars.entrySet()) {
			if(car.getValue().getMake().equalsIgnoreCase(make)) {
				tempCars.add(car.getValue());
			}
		}
		return Response.ok(tempCars).build();
	}
	
	@GET
	@Path("/get/type/{type}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCarByType(@PathParam("type") String type) {
		List<Car> tempCars = new ArrayList<Car>();
		for(Map.Entry<Long, Car> car:cars.entrySet()) {
			if(car.getValue().getType().equalsIgnoreCase(type)) {
				tempCars.add(car.getValue());
			}
		}
		return Response.ok(tempCars).build();
	}
	
	@GET
	@Path("/get/year/{year}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCarByYear(@PathParam("year") int year) {
		List<Car> tempCars = new ArrayList<Car>();
		for(Map.Entry<Long, Car> car:cars.entrySet()) {
			if(car.getValue().getYear() == year) {
				tempCars.add(car.getValue());
			}
		}
		return Response.ok(tempCars).build();
	}
	
	@GET
	@Path("/get/year/{year}/make/{make}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCarByYearAndMake(@PathParam("year") int year, @PathParam("make") String make) {
		List<Car> tempCars = new ArrayList<Car>();
		for(Map.Entry<Long, Car> car:cars.entrySet()) {
			if(car.getValue().getYear() == year  && car.getValue().getMake().equalsIgnoreCase(make)) {
				tempCars.add(car.getValue());
			}
		}
		return Response.ok(tempCars).build();
	}
	
	@GET
	@Path("/get/year/{year}/type/{type}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCarByYearAndType(@PathParam("year") int year, @PathParam("type") String type) {
		List<Car> tempCars = new ArrayList<Car>();
		for(Map.Entry<Long, Car> car:cars.entrySet()) {
			if(car.getValue().getYear() == year  && car.getValue().getType().equalsIgnoreCase(type)) {
				tempCars.add(car.getValue());
			}
		}
		return Response.ok(tempCars).build();
	}
	
	@GET
	@Path("/get/make/{make}/type/{type}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCarByMakeAndType(@PathParam("make") String make, @PathParam("type") String type) {
		List<Car> tempCars = new ArrayList<Car>();
		for(Map.Entry<Long, Car> car:cars.entrySet()) {
			if(car.getValue().getMake().equalsIgnoreCase(make)  && car.getValue().getType().equalsIgnoreCase(type)) {
				tempCars.add(car.getValue());
			}
		}
		return Response.ok(tempCars).build();
	}
	
	@GET
	@Path("/get/year/{year}/make/{make}/type/{type}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCarByYearMakeType(@PathParam("year") int year, @PathParam("make") String make, @PathParam("type") String type) {
		List<Car> tempCars = new ArrayList<Car>();
		for(Map.Entry<Long, Car> car:cars.entrySet()) {
			if(car.getValue().getYear() == year  && car.getValue().getMake().equalsIgnoreCase(make)  && car.getValue().getType().equalsIgnoreCase(type)) {
				tempCars.add(car.getValue());
			}
		}
		return Response.ok(tempCars).build();
	}
}