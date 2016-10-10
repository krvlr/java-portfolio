1
SELECT cars.id_car, cars.mileage, cars.colour
FROM cars INNER JOIN cars_owners ON (cars.id_car=cars_owners.id_car) INNER JOIN owners ON (owners.id_owner=cars_owners.id_owner)
WHERE (owners.city='Kazan');

2
SELECT owners.id_owner, owners.first_name, owners.last_name
FROM cars INNER JOIN cars_owners ON (cars.id_car=cars_owners.id_car) INNER JOIN owners ON (owners.id_owner=cars_owners.id_owner)
WHERE (cars.mileage > 100);

3
SELECT cars.id_car, cars.colour, cars.mileage, owners.first_name, owners.last_name
FROM cars INNER JOIN cars_owners ON (cars.id_car=cars_owners.id_car) INNER JOIN owners ON (owners.id_owner=cars_owners.id_owner)
WHERE (cars.mileage > 50) AND (DATE_PART('year', current_date) - (DATE_PART('year', owners.date_of_birth)) > 20);