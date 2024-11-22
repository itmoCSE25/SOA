import React, {useEffect, useState} from 'react';
import axios, {AxiosResponse} from 'axios';
import '../App.css';
import Modal from '../Modal/modal';
import Select from 'react-select';
import { parseStringPromise } from 'xml2js';
import Button from '@mui/material/Button';
import { TextField, Paper} from '@mui/material';



interface City {
    id: string;
    name: string;
    coordinates: Coordinates;
    creationDate: Date;
    area: number;
    population?: number;
    establishmentDate?: Date;
    metersAboveSeaLevel?: number;
    capital: boolean;
    government: Government;
    governor: Human;
}


interface Coordinates {
    x?: number;
    y: number;
}

enum Government {
    DESPOTISM = "DESPOTISM",
    PATRIARCHY = "PATRIARCHY",
    ETHNOCRACY = "ETHNOCRACY",
}

interface Human{
    height?: number;
    birthday?: Date;
}

const Table: React.FC = () => {
        const [id, setId] = useState('');
        const [name, setName] = useState('');
        const [coordinates, setCoordinates] = useState<Coordinates[]>([]);
        const [creationDate, setCreationDatee] = useState('');
        const [area, setArea] = useState('');
        const [population, setPopulation] = useState('');
        const [metersAboveSeaLevel, setMetersAboveSeaLevel] = useState('');
        const [establishmentDate, setEstablishmentDate] = useState('');
        const [capital, setCapital] = useState('');
        const [government, setGovernment] = useState<Government | null>(null);
        const [governor, setGovernor] = useState<Human[]>([]);
        const [x, setX] = useState('');
        const [y, setY] = useState('');
        const [height, setHeight] = useState('');
        const [birthday, setBirthday] = useState('');
        const [cityList, setCityList] = useState<City[]>([]);
        const [CityId, setCityId] = useState('');
        const [GovernmentId, setGovernmentId] = useState('');
        const [valueGovernment, setValueGovernment] = useState('');
        const [modalActive, setModalActive] = useState(false);
        const [response, setResponse] = useState<string | null>(null);
        const onChangeGovernment = (newValue: { label: Government; value: Government } | null) => {
            setGovernment(newValue ? newValue.value : null);
        };
        const governmentOptions = Object.values(Government).map((gov) => ({
            label: gov,
            value: gov
        }));

        const handleKeyPress = (e:any) => {
            // Запрещаем вводить всё, кроме цифр, точки и знака минус
            const regex = /^[0-9\.]+$/;
            if (!regex.test(e.key) && e.key !== 'Backspace' && e.key !== 'Delete') {
                e.preventDefault();
            }
        };
        
       const fetchUpdateCity = async () => {
        const xmlData = `
                <CitiesRequest>
                    <page>1</page>
                    <pageSize>100</pageSize>
                    <SortingStrategy>
                        <sortingType>asc</sortingType>
                        <sortingColumn>id</sortingColumn>
                    </SortingStrategy>
                    <FilterStrategy>
                        <filterColumn>id</filterColumn>
                        <filterType>contains</filterType>
                        <filterValue>string</filterValue>
                    </FilterStrategy>
                </CitiesRequest>
            `;
       }
        const fetchData = async () => {
            const xmlData = `
                <CitiesRequest>
                    <page>1</page>
                    <pageSize>100</pageSize>
                    <SortingStrategy>
                        <sortingType>asc</sortingType>
                        <sortingColumn>id</sortingColumn>
                    </SortingStrategy>
                    <FilterStrategy>
                        <filterColumn>id</filterColumn>
                        <filterType>contains</filterType>
                        <filterValue>string</filterValue>
                    </FilterStrategy>
                </CitiesRequest>
            `;
        
            try {
              const res = await fetch('http://localhost:9991/api/city/', {
                method: 'PUT',
                headers: {
                  'Content-Type': 'application/xml',
                },
                body: xmlData,
              });
        
              if (!res.ok) {
                throw new Error('Network response was not ok');
              }
        
              const xmlText = await res.text();
              const result = await parseStringPromise(xmlText);
              const cities = result.CitiesWithPagerDto.City;

              const updatedCityList: City[] = [...cityList]; // Копируем текущее состояние cityList

              cities.forEach((res:any) => {
                const foundOption = updatedCityList.findIndex(a => a.id === res.id[0]);
                
                // Извлекаем координаты
                const coordinates = {
                x: parseFloat(res.Coordinates[0].x[0]),
                y: parseFloat(res.Coordinates[0].y[0]),
                };
                const newCityData: City = {
                    id: res.id[0],
                    name: res.name[0],
                    coordinates: coordinates,
                    creationDate: res.creationDate[0],
                    area: parseFloat(res.area[0]),
                    population: parseInt(res.population[0]),
                    metersAboveSeaLevel: parseFloat(res.metersAboveSeaLevel[0]),
                    establishmentDate: res.establishmentDate[0],
                    capital: res.capital[0] === 'true', // Преобразование к boolean
                    government: res.government[0],
                    governor: res.Human.map((human: any) => ({
                      height: parseFloat(human.height[0]),
                      birthday: human.birthday[0],
                    })),
                  };
                  updatedCityList.push(newCityData);
                  console.warn("добавили город")
                  if (foundOption === -1) {
                    // Добавляем новый город
                    updatedCityList.push(newCityData);
                    console.warn("добавили город")
                  } else {
                    // Обновляем существующий город
                    updatedCityList[foundOption] = { ...updatedCityList[foundOption], ...newCityData };
                    console.warn("не добавили город")
                  }
                });
          
                setCityList(updatedCityList);
      
            } catch (error) {
              let errorMessage: string;
        
              // Проверка типа error
              if (error instanceof Error) {
                errorMessage = error.message; // Доступ к сообщению об ошибке
              } else {
                errorMessage = String(error); // Преобразуем в строку, если это не Error
              }
        
              console.error('Error:', errorMessage);
              setResponse(`Error: ${errorMessage}`);
            }}

        const fetchData1 = async () => {
            try {
                const response: AxiosResponse<{ cityList: City[] }> = await axios.get(
                    'http://localhost:9991/api/city',
                    {
                        headers: {'Access-Control-Allow-Origin': '*'},
                    }
                );
                console.log(response);
                setCityList(response.data.cityList);
                response.data.cityList.map((res, index) => {
                    const foundOption = cityList.findIndex(a => a.id === res.id);
                    if (foundOption === -1) {
                        cityList.push(res);
                    } else {
                        cityList[foundOption].name = res.name;
                        cityList[foundOption].coordinates = res.coordinates;
                        cityList[foundOption].creationDate = res.creationDate;
                        cityList[foundOption].area = res.area;
                        cityList[foundOption].population = res.population;
                        cityList[foundOption].establishmentDate = res.establishmentDate;
                        cityList[foundOption].metersAboveSeaLevel = res.metersAboveSeaLevel;
                        cityList[foundOption].capital = res.capital;
                        cityList[foundOption].government = res.government;
                    }
                    setCityList(cityList);
                })
            } catch (error) {
                console.error('Error fetching data:', error);
            }
        };
        
        useEffect(() => {
            fetchData()

        }, []);

        return (
            <div className="body">
                <br/>
                
                <div className="container">
                <Button variant="contained">Hello world</Button>
                
                <table className="selection">
                    <thead>
                        <tr>
                                <th>
                                <TextField id="outlined-basic" label="ID" variant="outlined" />
                                    <input
                                        id="get_city"
                                        placeholder="Введите значение"
                                        type='number'
                                        min="0"
                                        value={CityId}
                                        onChange={(e) => setCityId(e.target.value)}
                                    /> 
                                    <button className='add' onClick={async () => {                                          
                                                try {
                                                    const response = await fetch(`http://localhost:9991/api/city/${CityId}`, {
                                                        method: 'GET',
                                                        headers: {
                                                            'Content-Type': 'application/json'
                                                        }
                                                    });
                                                
                                                    if (response.ok) {
                                                        const data = await response.json();
                                                        console.log('City data:', data);
                                                        return data;
                                                    } else {
                                                        throw new Error(`HTTP error! Status: ${response.status}`);
                                                    }
                                                } catch (e) {
                                                    console.log('Fetching error', e);
                                                }                                         
                                            }}>Получить город по id</button>
                                </th>
                                <th>
                                    <input
                                        id="delete_city"
                                        placeholder="Введите значение"
                                        value={CityId}
                                        type='number'
                                        min="0"
                                        onChange={(e) => setCityId(e.target.value)}
                                    />                                
                                    <button className='add' onClick={async () => {                                          
                                                    try {
                                                        const response = await fetch(`http://localhost:9991/api/city/city?cityID=${CityId}`, {
                                                            method: 'DELETE',
                                                            headers: {
                                                                'Content-Type': 'application/json'
                                                            }
                                                        });

                                                        if (response.ok) {
                                                            delete cityList[Number({CityId})];
                                                            fetchData();
                                                        } else {
                                                            throw new Error(`HTTP error! Status: ${response.status}`);
                                                        }

                                                        const data = await response.json();
                                                        return data;
                                                    } catch (e) {
                                                        console.log('Sending error', e);
                                                    }
                                                }}>Удалить город по id </button>
                                    </th>
                                <th>
                                    <input
                                        id="get_government"
                                        placeholder="Введите значение"
                                        type='number'
                                        value={GovernmentId}
                                        min="0"
                                        max="2"
                                        onChange={(e) => setGovernmentId(e.target.value)}
                                    /> 
                                    <button className='add' onClick={async () => {                                          
                                                try {
                                                    const response = await fetch(`http://localhost:9991/api/external/government/${valueGovernment}`, {
                                                        method: 'GET',
                                                        headers: {
                                                            'Content-Type': 'application/json'
                                                        }
                                                    });
                                                
                                                    if (response.ok) {
                                                        const data = await response.json();
                                                        console.log('City data:', data);
                                                        return data;
                                                    } else {
                                                        throw new Error(`HTTP error! Status: ${response.status}`);
                                                    }
                                                } catch (e) {
                                                    console.log('Fetching error', e);
                                                }                                         
                                            }}>Город с government меньше заданного</button>
                                </th>
                        </tr>
                        <tr>
                            <th>
                                <button className='add' onClick={() => {
                                            setModalActive(true);
                                        }}>Обновить город по id</button>
                            </th>
                            <th>
                                <button className='add' onClick={async () => { 
                                    fetchData();
                                }}>Получить города с пагинацией</button>
                            </th>
                            <th>
                                <button className='add' onClick={async () => { 
                                    try {
                                        const response: AxiosResponse<{ cityList: City[] }> = await axios.get(
                                            'http://localhost:9991/api/external/min/id',
                                            {
                                                headers: {'Access-Control-Allow-Origin': '*'},
                                            }
                                        );
                                        console.log(response);
                                        setCityList(response.data.cityList);
                                        response.data.cityList.map((res, index) => {
                                            const foundOption = cityList.findIndex(a => a.id === res.id);
                                            if (foundOption === -1) {
                                                cityList.push(res);
                                            } else {
                                                cityList[foundOption].name = res.name;
                                                cityList[foundOption].coordinates = res.coordinates;
                                                cityList[foundOption].creationDate = res.creationDate;
                                                cityList[foundOption].area = res.area;
                                                cityList[foundOption].population = res.population;
                                                cityList[foundOption].metersAboveSeaLevel = res.metersAboveSeaLevel;
                                                cityList[foundOption].capital = res.capital;
                                                cityList[foundOption].government = res.government;
                                            }
                                            setCityList(cityList);
                                        })
                                    } catch (error) {
                                        console.error('Error fetching data:', error);
                                    }
                                }}>Город с минимальным id</button>
                            </th>
                            <th>
                                <button className='add' onClick={async () => { 
                                    try {
                                        const response: AxiosResponse<{ cityList: City[] }> = await axios.get(
                                            'http://localhost:9991/api/external/max/establishment-date',
                                            {
                                                headers: {'Access-Control-Allow-Origin': '*'},
                                            }
                                        );
                                        console.log(response);
                                        setCityList(response.data.cityList);
                                        response.data.cityList.map((res, index) => {
                                            const foundOption = cityList.findIndex(a => a.id === res.id);
                                            if (foundOption === -1) {
                                                cityList.push(res);
                                            } else {
                                                cityList[foundOption].name = res.name;
                                                cityList[foundOption].coordinates = res.coordinates;
                                                cityList[foundOption].creationDate = res.creationDate;
                                                cityList[foundOption].area = res.area;
                                                cityList[foundOption].population = res.population;
                                                cityList[foundOption].metersAboveSeaLevel = res.metersAboveSeaLevel;
                                                cityList[foundOption].capital = res.capital;
                                                cityList[foundOption].government = res.government;
                                            }
                                            setCityList(cityList);
                                        })
                                    } catch (error) {
                                        console.error('Error fetching data:', error);
                                    }
                                }}>Город с максимальной датой</button>
                            </th>                                                 
                        </tr>                                                            
                    </thead>
                </table>
                    <br></br>
                    <table className="flower">
                        <thead>
                        <tr>
                            <th>Название</th>
                            <th>Коордианты</th>
                            <th>Площадь</th>
                            <th>Население</th>
                            <th>Высота над уровнем моря</th>
                            <th>Тип правительства</th>
                            <th>Мэр</th>
                        </tr>
                        </thead>
                        <tbody>
                        {
                            cityList.map((city, index) => (
                                <tr key={city.id}>
                                    <td>{city.name}</td>
                                    <td>{city.coordinates.x};{city.coordinates.y}</td>
                                    <td>{city.area}</td>
                                    <td>{city.population}</td>
                                    <td>{city.metersAboveSeaLevel}</td>
                                    <td>{city.government}</td>
                                    <td>{city.governor.height}</td>                                      
                                </tr>
                            ))}
                        </tbody>
                    </table>

                    { <Modal active={modalActive} setActive={setModalActive}>
                        
                        <table className="tableAdd">
                            <tr>
                                <td>
                                    <p>ID</p>
                                    <input id="id" type="number" value={id} pattern="\d*"
                                    onChange={(e) => setId(e.target.value)}/>
                                </td>
                                <td>
                                    <p>Название</p>
                                    <input type="text" value={name} onChange={(e) => setName(e.target.value)}/>
                                </td>
                                <td>
                                    <p>Коордианты</p>
                                    <input id="x" type="number" value={x} pattern="\d*"
                                           onChange={(e) => setX(e.target.value)}/>
                                    <input id="y" type="number" value={y} pattern="\d*"
                                    onChange={(e) => setY(e.target.value)}/>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <p>Площадь</p>
                                    <input id="area" type="number" value={area} pattern="\d*"
                                    onChange={(e) => setArea(e.target.value)}/>
                                </td>
                                <td>
                                    <p>Население</p>
                                    <input id="population" type="number" value={population} pattern="\d*"
                                    onChange={(e) => setPopulation(e.target.value)}/>
                                </td>
                                <td>
                                    <p>Высота над УМ</p>
                                    <input id="metersAboveSeaLevel" type="texnumbert" value={metersAboveSeaLevel} pattern="\d*"
                                    onChange={(e) => setMetersAboveSeaLevel(e.target.value)}/>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <p>Тип правительства</p>
                                    <Select 
                                        classNamePrefix="select_type" 
                                        onChange={onChangeGovernment} 
                                        value={governmentOptions.find(option => option.value === government) || null}
                                        options={governmentOptions}
                                        inputValue={""}
                                        onInputChange={() => {}} 
                                        onMenuOpen={() => {}} 
                                        onMenuClose={() => {}}
                                    />
                                </td>
                                <td>
                                    <p>Мэр</p>
                                    <input id="height" type="number" value={height} pattern="\d*"
                                    onChange={(e) => setHeight(e.target.value)}/>
                                </td>
                                <td>
                                    <button
                                        className="but"
                                        disabled={name.length === 0}
                                        type="button"
                                        onClick={async () => {
                                            setId((cityList.length + 1).toString());
                                            try {
                                                const response = await fetch('http://localhost:9991/api/flowers/100/flowers/add', {
                                                    method: 'PUT',
                                                    headers: {
                                                        'Content-Type': 'application/json'
                                                    },
                                                    body: JSON.stringify({
                                                        id,
                                                        name,
                                                        coordinates: {
                                                            x,
                                                            y
                                                        },
                                                        area,
                                                        population,
                                                        metersAboveSeaLevel,
                                                        government,
                                                        governor:{
                                                            height,
                                                            birthday
                                                        }

                                                    })
                                                });
                                                if (response.ok) {
                                                    fetchData();

                                                } else {
                                                    throw new Error(`HTTP error! Status: ${response.status}`);
                                                }
                                                const data = await response.json();
                                                console.log(data);
                                            } catch (e) {
                                                console.log('Sending error', e);
                                            } finally {
                                                setModalActive(false);
                                            }
                                        }}
                                    >
                                        Применить
                                    </button>
                                </td>
                            </tr>
                        </table>
                    </Modal> }
                </div>
            </div>
        );
    }
;

export default Table;
