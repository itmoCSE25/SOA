import * as React from 'react';
import Button from '@mui/material/Button';
import Stack from '@mui/material/Stack';
import { City } from '../models/City';
import {useState} from 'react';

interface ButtonsProps {
  inputValue: string;
  onCityUpdate: (city: City[]) => void; 
}

const GetGovernmentButton: React.FC<ButtonsProps> = ({ inputValue, onCityUpdate }) => {
  const [cities, setCities] = useState<City[]>([]);

    const handleButtonClick = async () => {
    try {
      const response = await fetch(`http://localhost:9991/api/external/government?type=${inputValue}`);
      if (!response.ok) {
        throw new Error('Network response was not ok');
      }
      const xmlText = await response.text(); 
      const parser = new DOMParser();
      const xmlDoc = parser.parseFromString(xmlText, "text/xml"); 
      const ids = xmlDoc.getElementsByTagName("id");
      const n = ids.length;
      for (var i = 0; i < n; i++){
        const city: City = {
          id: xmlDoc.getElementsByTagName("id")[i]?.textContent || '',
          name: xmlDoc.getElementsByTagName("name")[i]?.textContent || '',
          coordinates: {
            x: xmlDoc.getElementsByTagName("x")[i]?.textContent || '0',
            y: xmlDoc.getElementsByTagName("y")[i]?.textContent || '0',
          },
          creationDate: new Date(xmlDoc.getElementsByTagName("creationDate")[i].textContent || 0),
          area: xmlDoc.getElementsByTagName("area")[i]?.textContent || '0',
          population: xmlDoc.getElementsByTagName("population")[i]?.textContent || '0',
          metersAboveSeaLevel: xmlDoc.getElementsByTagName("metersAboveSeaLevel")[i]?.textContent || '0',
          establishmentDate: new Date(xmlDoc.getElementsByTagName("establishmentDate")[i]?.textContent || 0),
          capital: xmlDoc.getElementsByTagName("capital")[i]?.textContent === 'true',
          government: xmlDoc.getElementsByTagName("government")[i]?.textContent || '', 
          governor: {
            height: xmlDoc.getElementsByTagName("height")[i]?.textContent || '0',
            birthday: new Date(xmlDoc.getElementsByTagName("birthday")[i]?.textContent || 0),
          },
          human: Array.from(xmlDoc.getElementsByTagName("inhabitant")).map(humanElement => ({
            height: humanElement.getElementsByTagName("height")[0]?.textContent || '0',
            birthday: new Date(humanElement.getElementsByTagName("birthday")[0]?.textContent || 0),
          })),
      }
      setCities((prev) => [...prev, ...[city]]);
      };
      onCityUpdate(cities);
      
    } catch (error) {
      console.error('Error fetching city data:', error);
    }
  };
  return (
    <Stack direction="row" spacing={2}>
      <Button variant="outlined" onClick={handleButtonClick}>Города c government меньше заданного</Button>
    </Stack>
  );
}
export default GetGovernmentButton;

