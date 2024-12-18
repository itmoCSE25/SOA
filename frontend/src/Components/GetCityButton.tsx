import * as React from 'react';
import Button from '@mui/material/Button';
import Stack from '@mui/material/Stack';
import { City } from '../models/City'; 
import { Government } from '../models/Government'; 

interface ButtonsProps {
  inputValue: string;
  onCityUpdate: (city: City) => void; 
}

const GetCityButton: React.FC<ButtonsProps> = ({ inputValue, onCityUpdate }) => {
  const handleButtonClick = async () => {
    try {
      const response = await fetch(`https://localhost:7171/soa-service/api/cities/${inputValue}`);
      if (!response.ok) {
        throw new Error('Network response was not ok');
      }
      const xmlText = await response.text(); 
      const parser = new DOMParser();
      const xmlDoc = parser.parseFromString(xmlText, "text/xml"); 

      const city: City = {
        id: xmlDoc.getElementsByTagName("id")[0]?.textContent || '',
        name: xmlDoc.getElementsByTagName("name")[0]?.textContent || '',
        coordinates: {
          x: xmlDoc.getElementsByTagName("x")[0]?.textContent || '0',
          y: xmlDoc.getElementsByTagName("y")[0]?.textContent || '0',
        },
        creationDate: new Date(xmlDoc.getElementsByTagName("creationDate")[0].textContent || 0),
        area: xmlDoc.getElementsByTagName("area")[0]?.textContent || '0',
        population: xmlDoc.getElementsByTagName("population")[0]?.textContent || '0',
        metersAboveSeaLevel: xmlDoc.getElementsByTagName("metersAboveSeaLevel")[0]?.textContent || '0',
        establishmentDate: new Date(xmlDoc.getElementsByTagName("establishmentDate")[0]?.textContent || 0),
        capital: xmlDoc.getElementsByTagName("capital")[0]?.textContent === 'true',
        government: xmlDoc.getElementsByTagName("government")[0]?.textContent as Government,
        governor: {
          height: xmlDoc.getElementsByTagName("height")[0]?.textContent || '0',
          birthday: new Date(xmlDoc.getElementsByTagName("birthday")[0]?.textContent || 0),
        },
        human: Array.from(xmlDoc.getElementsByTagName("inhabitant")).map(humanElement => ({
          height: humanElement.getElementsByTagName("height")[0]?.textContent || '0',
          birthday: new Date(humanElement.getElementsByTagName("birthday")[0]?.textContent || 0),
        })),
      };

      onCityUpdate(city);
    } catch (error) {
      console.error('Error fetching city data:', error);
    }
  };


  return (
    <Stack direction="row" spacing={2}>
      <Button variant="outlined" onClick={handleButtonClick}>Получить</Button>
    </Stack>
  );
}
export default GetCityButton;

