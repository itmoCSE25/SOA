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
    creation_date          timestamp with time zone,
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
    city int references city (id)
);