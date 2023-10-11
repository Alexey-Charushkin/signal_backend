INSERT INTO users (name, email, password, telegram_id, address, phone_number, role)
VALUES ('Вася Пупкин', 'vasja@mail.ru', 'jaVasija', '+78843576009', 'Москва, ул. Льва Толстого, д. 16', '+79608495455', 'USER');

INSERT INTO users (name, email, password, telegram_id, address, phone_number, role)
VALUES ('Петя', 'petiaja@mail.ru', 'Petia', '843576009', 'address22', '+76829954545', 'USER');

INSERT INTO restaurants (name, address, phone, email)
VALUES ('Супер ресторан', 'Москва, бульв. Новинский, д. 8, стр. 1', '+70943578038', 'super@mail.ru');

INSERT INTO dishes (description, price, category, preparation_time)
VALUES ('Супер блюдо', '48.12', 'pizza', '59');

INSERT INTO orders (user_id, restaurant_id, status, payment_method)
VALUES ('1', '1', 'NEW', 'DELIVERY');

INSERT INTO ordereddishes (order_id, dish_id, quantity)
VALUES ('1', '1', '2');