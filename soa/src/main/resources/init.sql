create table public.coordinates
(
    id serial primary key,
    x  float,
    y  int not null
);

create table public.city
(
    id                     serial primary key,
    name                   text not null,
    creation_date          timestamp with time zone default now() not null,
    area                   float,
    population             bigint,
    meters_above_sea_level double precision,
    establishment_date     timestamp with time zone,
    capital                bool,
    government             text
);

create table public.human
(
    id          serial primary key,
    height      float,
    birthday    timestamp with time zone,
    city        int references city (id) on delete cascade,
    is_governor bool
);

create table public.coordinate
(
    id   serial primary key,
    x    double precision,
    y    int,
    city int references city (id) on delete cascade
);

insert into city (name, area, population, meters_above_sea_level, establishment_date, capital, government)
values ('Test', 2.0, 2, 100, now(), null, null);

insert into city (name, area, population, meters_above_sea_level, establishment_date, capital, government)
values ('Test2', 2.0, 2, 100, now(), null, null);

insert into city (name, area, population, meters_above_sea_level, establishment_date, capital, government)
values ('Test3', 2.0, 2, 100, now(), null, null);

insert into human (height, birthday, city, is_governor)
values (100, now(), 1, false),
       (110, now(), 1, true);

insert into human (height, birthday, city, is_governor)
values (1, now(), 2, false),
       (2, now(), 2, true);