import * as React from 'react';
import Paper from '@mui/material/Paper';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TablePagination from '@mui/material/TablePagination';
import TableRow from '@mui/material/TableRow';
import axios from 'axios';
import {useEffect, useState} from 'react';
import Input from "./Input";
import GetCityButton from "./GetCityButton";
import { City } from '../models/City'; 
import Button from '@mui/material/Button';
import Stack from '@mui/material/Stack';
import Modal from '../Modal/modal';
import GetMinIdCityButton from './GetMinIdCityButton';
import GetMaxDateCityButton from './GetMaxDateCityButton';
import GetGovernmentButton from './GetGovernmentButton';
import Selects from './Selects';
import ButtonGroup from '@mui/material/ButtonGroup';
import '../App.css';
import { Human } from '../models/Human';
import GetDeportButton from './GetDeportButton';
import GetKillButton from './GetKillButton';
import FormControlLabel from '@mui/material/FormControlLabel';
import Switch from '@mui/material/Switch';
import DateInputs from './DateInputs';
import dayjs from 'dayjs';
import SelectSort from './SelectSort';
import SelectTypeSort from './SelectTypeSort';
import SelectFieldFilter from './SelectFieldFilter';
import SelectTypeFilter from './SelectTypeFilter';
interface Column {
  id: keyof City;  
  label: string;
  minWidth?: number;
  align?: 'left';
  format?: (value: number) => string;
}

interface ColumnHuman {
  id: keyof Human;  
  label: string;
  minWidth?: number;
  align?: 'left';
  format?: (value: number) => string;
}

const columnsHuman: readonly ColumnHuman[] = [
  {
    id: 'height',
    label: 'Height',
    minWidth: 30,
    align: 'left',
    format: (value: number) => value.toLocaleString('en-US'),
  },
  {
    id: 'birthday',
    label: 'Birthday',
    minWidth: 30,
    align: 'left',
  },
]

const columns: readonly Column[] = [
  { id: 'id',
    label: 'ID', 
    minWidth: 20, 
    align: 'left',
    format: (value: number) => value.toLocaleString('en-US'),
  },
  { id: 'name',
    label: 'Name', 
    minWidth: 60, 
    align: 'left'
  },
  {
    id: 'area',
    label: 'Area',
    minWidth: 50,
    align: 'left',
    format: (value: number) => value.toLocaleString('en-US'),
  },
  {
    id: 'coordinates',
    label: 'Coordinates',
    minWidth: 100,
    align: 'left',
    format: (value: number) => value.toLocaleString('en-US'),
  },
  {
    id: 'population',
    label: 'Population',
    minWidth: 60,
    align: 'left',
    format: (value: number) => value.toLocaleString('en-US'),
  },
  {
    id: 'capital',
    label: 'Capital',
    minWidth: 40,
    align: 'left',
  },

  {
    id: 'metersAboveSeaLevel',
    label: 'Sea Level',
    minWidth: 40,
    align: 'left',
    format: (value: number) => value.toLocaleString('en-US'),
  },
  {
    id: 'government',
    label: 'Government',
    minWidth: 70,
    align: 'left',
  },

  {
    id: 'creationDate',
    label: 'Creation',
    minWidth: 70,
    align: 'left',
  },
  {
    id: 'establishmentDate',
    label: 'Establishment',
    minWidth: 70,
    align: 'left',
  },
  {
    id: 'governor',
    label: 'Governor',
    minWidth: 70,
    align: 'left',
  },
  
];


const formatValue = (value: any) => {
    if (value === null || value === undefined) {
        return 'N/A'; 
    }
    
    if (typeof value === 'number') {
        return value.toLocaleString('en-US'); 
    } else if (typeof value === 'boolean') {
        return value ? 'Yes' : 'No'; 
    } else if (value instanceof Date) {
        return value.toLocaleDateString(); 
    } else if (typeof value === 'object') {
        if ('x' in value && 'y' in value) {
            return `(${value.x ?? 0}, ${value.y})`; 
        }
        if ('height' in value) {
            return `${value.height ?? 'N/A'} cm`; 
        }
        return JSON.stringify(value); 
    }   
    return String(value); 
};

const TableCity: React.FC = () => {
  const [cities, setCities] = useState<City[]>([]);
  const [humans, setHumans] = useState<Human[]>([]);
  const [page, setPage] = React.useState(0);
  const [rowsPerPage, setRowsPerPage] = React.useState(100);
  const [inputValue, setInputValue] = useState("");
  const [inputFrom, setInputFrom] = useState("");
  const [inputTo, setInputTo] = useState("");
  const [inputKill, setInputKill] = useState("");
  const [modalActive, setModalActive] = useState(false);
  const [id, setID] = useState("");
  const [name, setName] = useState("");
  const [creationDate, setCreationDatee] = useState(new Date());
  const [area, setArea] = useState("");
  const [population, setPopulation] = useState("");
  const [metersAboveSeaLevel, setMetersAboveSeaLevel] = useState("");
  const [establishmentDate, setEstablishmentDate] = useState<Date | null>(null);
  const [capital, setCapital] = useState(Boolean);
  const [x, setX] = useState("");
  const [y, setY] = useState("");
  const [height, setHeight] = useState("");
  const [birthday, setBirthday] = useState<Date | null>(null);
  const [selectGovernment, setSelectGovernment] = React.useState('DESPOTISM');
  const [selectFieldSort, setSelectFieldSort] = React.useState('ID');
  const [selectTypeSort, setSelectTypeSort] = React.useState('ASC');
  const [selectFieldFilter, setSelectFieldFilter] = React.useState('ID');
  const [selectTypeFilter, setSelectTypeFilter] = React.useState('CONTAINS');
  const [inputValueFilter, setInputValueFilter] = React.useState('');

  
  const [add, setAdd] = React.useState(Boolean);

    const handleSwitchChange = () => {
        setCapital((prev) => !prev); 
    };

  
  const handleCityUpdate = (newCity: City) => {
    setCities([newCity]);
    setHumans(newCity.human)
  };

  const handleCityUpdateList = (newCity: City[]) => {
    setCities(newCity);
    reverseList(newCity);
  };

  const handleChangePage = (event: unknown, newPage: number) => {
    setPage(newPage);
  };

  const handleChangeRowsPerPage = (event: React.ChangeEvent<HTMLInputElement>) => {
    setRowsPerPage(+event.target.value);
    setPage(0);
    fetchCities();
  };
  
  const SetData = (value: string) => {
    const index = Number(value) - 1; 
    if (index >= 0 && index < cities.length) {
        const selectedCity = cities[index];
        setID(inputValue);
        setName(selectedCity.name);
        setArea(selectedCity.area);
        setX(selectedCity.coordinates.x ?? '');
        setY(selectedCity.coordinates.y);
        setPopulation(selectedCity.population ?? '');
        setCapital(selectedCity.capital);
        setMetersAboveSeaLevel(selectedCity.metersAboveSeaLevel ?? '');      
        setCreationDatee(new Date(selectedCity.creationDate));
        setEstablishmentDate(new Date(selectedCity.establishmentDate ?? new Date()));
        const humans = selectedCity.human;
        humans.map(g => setHeight(g.height ?? ''));
        humans.map(g => setBirthday(new Date(g.birthday ?? new Date())));
        setSelectGovernment(selectedCity.government);
    }};
  const reverseList = (city: City[]) => {
    setCities(prevList => [...prevList].reverse());  
  };

  const fetchDeleteCity = async () => {
    try {
      const response = await fetch(`https://localhost:7171/soa-service/api/cities/${inputValue}`, {
        method: 'DELETE',      
      });
      if (response.ok) {
        console.log('City successfully deleted');
        fetchCities();
      } else if (response.status === 400) {
        console.error("Can't find city with such id");
      } else if (response.status >= 500) {
        console.error('Internal server error');
      }
    } catch (error) {
      console.error('Error deleting city:', error);
    }
  };


  const fetchUpdateCity = async () => {
    const requestData = `<?xml version="1.0" encoding="UTF-8"?>
        <CityRequest>
        <name>${name}</name>
        <coordinates>
          <x>${x}</x>
          <y>${y}</y>
        </coordinates>
        <area>${area}</area>
        <population>${population}</population>
        <metersAboveSeaLevel>${metersAboveSeaLevel}</metersAboveSeaLevel>
        <establishmentDate>2024-11-22T00:41:50.823Z</establishmentDate>
        <capital>${capital}</capital>
        <government>${selectGovernment}</government>
        <governor>
          <height>${height}</height>
          <birthday>2024-11-22T00:41:50.823Z</birthday>
        </governor>
      </CityRequest>`;

        try {
          const response = await fetch(`https://localhost:7171/soa-service/api/cities/${id}`, {
            method: 'PUT',
                headers: {
                  'Content-Type': 'application/xml',
                },
                body: requestData,
              });
          
              if (!response.ok) {
                throw new Error('Network response was not ok');
              }        
              fetchCities();
      } catch (error) {
          console.error("Error fetching cities:", error);
      }
    }

    const fetchCreateCity = async () => {
      const requestData = `<?xml version="1.0" encoding="UTF-8"?>
<CityRequest>
  <name>${name}</name>
  <coordinates>
    <x>${x}</x>
    <y>${y}</y>
  </coordinates>
  <area>${area}</area>
  <population>${population}</population>
  <metersAboveSeaLevel>${metersAboveSeaLevel}</metersAboveSeaLevel>
  <establishmentDate>2024-11-22T00:41:50.823Z</establishmentDate>
  <capital>${capital}</capital>
  <government>${selectGovernment}</government>
  <governor>
    <height>${height}</height>
    <birthday>2024-11-22T00:41:50.823Z</birthday>
  </governor>
</CityRequest>`;
  
      try {
          const response = await fetch(`https://localhost:7171/soa-service/api/external/cities`, {
            method: 'POST',
                headers: {
                  'Content-Type': 'application/xml',
                },
                body: requestData,
              });

          if (!response.ok) {
            throw new Error('Network response was not ok');
          }        
          fetchCities();
      } catch (error) {
          console.error("Error fetching cities:", error);
      }
  }; 

  const fetchCities = async () => {
      const requestData = `<?xml version="1.0" encoding="UTF-8"?>
          <CitiesRequest>
          <page>${page + 1}</page>
          <pageSize>${rowsPerPage}</pageSize>
          <SortingStrategy>
          <sortingType>${selectTypeSort}</sortingType>
          <sortingColumn>${selectFieldSort}</sortingColumn>
          </SortingStrategy>
          <FilterStrategy>
          <filterColumn>${selectFieldFilter}</filterColumn>
          <filterType>${selectTypeFilter}</filterType>
          <filterValue>${inputValueFilter}</filterValue>
          </FilterStrategy>
          </CitiesRequest>`;

      try {
          const response = await axios.post('https://localhost:7171/soa-service/api/cities', requestData, {
              headers: {
                  'Content-Type': 'application/xml',
              },
          });
          
          const parser = new DOMParser();
          const xmlDoc = parser.parseFromString(response.data, "application/xml");

          const ids = xmlDoc.getElementsByTagName("id");
          const n = ids.length;
          setCities([]);
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
          setCities((prev) => [...prev, ...[city]]);}
          reverseList(cities);
      } catch (error) {
          console.error("Error fetching cities:", error);
      }
  };

useEffect(() => {  
  fetchCities();
}, []);


  return (
    <div style={{ display: 'flex', flexDirection: 'row', justifyContent: 'space-between' }}>

      <div style={{ marginRight: '10px', marginLeft: '10px'}}>
        <Input text='ID' value={inputValue} onInputChange={setInputValue} type='int' />     
        <ButtonGroup variant="contained" aria-label="Basic button group">
        <GetCityButton inputValue={inputValue} onCityUpdate={handleCityUpdate}/>
          <Stack direction="row" spacing={2}>
            <Button variant="outlined" onClick={fetchDeleteCity}>Удалить</Button>
          </Stack>
          <Stack direction="row" spacing={2}>
            <Button variant="outlined" onClick={() => {
                                                SetData(inputValue);
                                                setModalActive(true);
                                                setAdd(false);
                                            }}>Редактировать</Button>
          </Stack>               
        </ButtonGroup>
      
        
        <div style={{marginTop: 10}}>
          <table>
            <td>
             <GetMinIdCityButton onCityUpdate={handleCityUpdate}></GetMinIdCityButton>
            </td>
            <td>
              <GetMaxDateCityButton onCityUpdate={handleCityUpdate}></GetMaxDateCityButton>  
            </td>
          </table>   
        </div>
        <table>
          <td>
            <GetGovernmentButton inputValue={selectGovernment} onCityUpdate={handleCityUpdateList}></GetGovernmentButton>
          </td>
          <td>
            <Selects value={selectGovernment} onChange={setSelectGovernment}></Selects>
          </td>
        </table>
          <table>
            <tr>
              <td>
                <GetDeportButton inputFrom={inputFrom} inputTo={inputTo}></GetDeportButton>
              </td>
              <td>
                <ButtonGroup>
                  <Input text='From' value={inputFrom} onInputChange={setInputFrom} type='float'></Input>
                  <Input text='To' value={inputTo} onInputChange={setInputTo} type='int'></Input>
                </ButtonGroup>
              </td>      
            </tr>
            <tr>
              <td>
                <GetKillButton inputValue={inputKill}></GetKillButton>
              </td>
              <td>
                <Input text='Kill' value={inputKill} onInputChange={setInputKill} type='int'></Input>

              </td>        
            </tr>     
          </table>
        
        
        <div>
          <br></br>
        <Paper sx={{ width: '100%', overflow: 'hidden', marginRight:2}}>
        <TableContainer sx={{ maxHeight: 440}} >
          <Table stickyHeader aria-label="sticky table">
            <TableHead>
              <TableRow >
                {columnsHuman.map((column) => (
                  <TableCell
                    key={column.id}
                    align={column.align}
                    style={{ minWidth: column.minWidth, zIndex:0}}
                  >
                    {column.label}
                  </TableCell>
                ))}
              </TableRow>
            </TableHead>
            <TableBody>
            {
            humans
              .slice(page * rowsPerPage, page * rowsPerPage + rowsPerPage)
              .map((human) => {
                  return (
                      <TableRow hover role="checkbox" tabIndex={-1} key={human.height}>
                          {columnsHuman.map((column) => {
                              const value = human[column.id];
                              return (
                                  <TableCell key={column.id} align={column.align}>
                                      {formatValue(value)}
                                  </TableCell>
                              );
                          })}
                      </TableRow>
                  );})}
          </TableBody>
          </Table>
        </TableContainer>
        <TablePagination
          rowsPerPageOptions={[100, 200, 1000]}
          component="div"
          count={cities.length}
          rowsPerPage={rowsPerPage}
          page={page}
          onPageChange={handleChangePage}
          onRowsPerPageChange={handleChangeRowsPerPage}
        />
      </Paper>
        </div>      
      </div>
      
      <Paper sx={{ width: '100%', overflow: 'hidden', marginRight:2}}>
        <div>
        <Stack direction="row" spacing={1}>
              <Button variant="outlined" onClick={() => {
                                                  fetchCities();                                            
                                                  }}>Все города
              </Button>
              {/* <Button variant="outlined" onClick={() => {
                                                  setAdd(true);
                                                  setModalActive(true);                                                                                         
                                                  }}>Создать город</Button>  */}
              <SelectSort value={selectFieldSort} onChange={setSelectFieldSort}></SelectSort> 
              <SelectTypeSort value={selectTypeSort} onChange={setSelectTypeSort}></SelectTypeSort> 
              <SelectFieldFilter value={selectFieldFilter} onChange={setSelectFieldFilter}></SelectFieldFilter>
              <SelectTypeFilter value={selectTypeFilter} onChange={setSelectTypeFilter}></SelectTypeFilter>
              <Input text='ValueFilter' value={inputValueFilter} onInputChange={setInputValueFilter} type='string'></Input>


         </Stack>                                         
        </div>
        <TableContainer sx={{ maxHeight: 700}} >
          <Table stickyHeader aria-label="sticky table">
            <TableHead>
              <TableRow >
                {columns.map((column) => (
                  <TableCell
                    key={column.id}
                    align={column.align}
                    style={{ minWidth: column.minWidth, zIndex:0}}
                  >
                    {column.label}
                  </TableCell>
                ))}
              </TableRow>
            </TableHead>
            <TableBody>
              {cities
                  .slice(page * rowsPerPage, page * rowsPerPage + rowsPerPage)
                  .map((city) => {
                      return (
                          <TableRow hover role="checkbox" tabIndex={-1} key={city.id}>
                              {columns.map((column) => {
                                  const value = city[column.id];
                                  return (
                                      <TableCell key={column.id} align={column.align}>
                                          {formatValue(value)}
                                      </TableCell>
                                  );
                              })}
                          </TableRow>
                      );
                  })}
            </TableBody>
          </Table>
        </TableContainer>
        <TablePagination
          rowsPerPageOptions={[100, 20, 10]}
          component="div"
          count={cities.length}
          rowsPerPage={rowsPerPage}
          page={page}
          onPageChange={handleChangePage}
          onRowsPerPageChange={handleChangeRowsPerPage}
        />
      </Paper>

    
      { <Modal active={modalActive} setActive={setModalActive}>
        <div>
            <table className="tableAdd">
              <tr>
                <td><Input text='Name' value={name} onInputChange={(value: string) => setName(value)} type='string'/></td>
                <td><Input text='Area' value={String(area)} onInputChange={(value: string) => setArea(value)}  type='float'/></td>
                <td><Input text='X' value={String(x)} onInputChange={(value: string) => setX(value)} type='float'/></td>
                <td><Input text='Y' value={String(y)} onInputChange={(value: string) => setY(value)} type='float'/></td>
              </tr>
              <tr>
                <td><Input text='Population' value={String(population)} onInputChange={(value: string) => setPopulation(value)} type='int'/></td>
                <td><Input text='Meters Above Sea Level' value={String(metersAboveSeaLevel)} onInputChange={(value: string) => setMetersAboveSeaLevel(value)} type='int'/></td>
                <td><Input text='Governor Height' value={String(height)} onInputChange={(value: string) => setHeight(value)} type='float'/></td>
                <td><Selects value={selectGovernment} onChange={setSelectGovernment}></Selects></td>
              </tr>         
              <table>
                <tr>     
                  {/* <td>
                    <DateInputs text='Establishment Date' value={dayjs(establishmentDate)} onInputChange={setEstablishmentDate}></DateInputs>
                  </td>
                  <td>
                    <DateInputs text='Governor birthday' value={dayjs(birthday)} onInputChange={setBirthday}></DateInputs>
                  </td> */}
                  <td>
                    <FormControlLabel sx={{marginLeft:2}} control={<Switch checked={capital} onChange={handleSwitchChange} />} label="Capital" />
                  </td>
                </tr>
              </table>
            </table>
            <table className="tableAdd">
              <tr>
                  <td></td>
                  <td>
                  {add ? (
                    <Button variant="outlined" onClick={fetchCreateCity}>Создать</Button>
                  ) : (
                    <Button variant="outlined" onClick={fetchUpdateCity}>Изменить</Button>)}
                  </td>
                  <td></td>
                </tr>
            </table>
        </div>
    </Modal>}
    </div>    
    
  );
}
export default TableCity;