CREATE TABLE `member` (
    `id` int PRIMARY KEY AUTO_INCREMENT,
    `email` varchar(255),
    `username` varchar(255),
    `password` varchar(255)
);

CREATE TABLE `book` (
    `id` int PRIMARY KEY AUTO_INCREMENT,
    `category_id` int,
    `name` varchar(255),
    `stock` int,
    `price` int
);

CREATE TABLE `category` (
    `id` int PRIMARY KEY AUTO_INCREMENT,
    `name` varchar(255)
);

CREATE TABLE `cart` (
    `id` int PRIMARY KEY AUTO_INCREMENT,
    `member_id` int,
    `created_at` datetime
);

CREATE TABLE `cart_unit` (
    `id` int PRIMARY KEY AUTO_INCREMENT,
    `cart_id` int,
    `book_id` int,
    `amount` int
);

CREATE TABLE `order` (
    `id` int PRIMARY KEY AUTO_INCREMENT,
    `cart_id` int,
    `created_at` datetime
);

CREATE TABLE `order_unit` (
    `id` int PRIMARY KEY AUTO_INCREMENT,
    `order_id` int,
    `book_id` int,
    `price` int,
    `amount` int
);

ALTER TABLE `book` ADD FOREIGN KEY (`category_id`) REFERENCES `category` (`id`);

ALTER TABLE `cart` ADD FOREIGN KEY (`member_id`) REFERENCES `member` (`id`);

ALTER TABLE `cart_unit` ADD FOREIGN KEY (`cart_id`) REFERENCES `cart` (`id`);

ALTER TABLE `cart_unit` ADD FOREIGN KEY (`book_id`) REFERENCES `book` (`id`);

ALTER TABLE `order` ADD FOREIGN KEY (`cart_id`) REFERENCES `cart` (`id`);

ALTER TABLE `order_unit` ADD FOREIGN KEY (`order_id`) REFERENCES `order` (`id`);

ALTER TABLE `order_unit` ADD FOREIGN KEY (`book_id`) REFERENCES `book` (`id`);
