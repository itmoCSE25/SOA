import { Coordinates } from './Coordinates';
import { Human } from './Human';

export interface City {
    id: string;
    name: string;
    coordinates: Coordinates;
    creationDate: Date;
    area: string;
    population?: string;
    establishmentDate?: Date;
    metersAboveSeaLevel?: string;
    capital: boolean;
    government: string;
    governor: Human;
    human: Human[];
}
