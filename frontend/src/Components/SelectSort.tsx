import * as React from 'react';
import InputLabel from '@mui/material/InputLabel';
import MenuItem from '@mui/material/MenuItem';
import FormControl from '@mui/material/FormControl';
import Select, { SelectChangeEvent } from '@mui/material/Select';


interface Props {
  value: string;
  onChange: (value: string) => void;
}

const SelectSort: React.FC<Props> = ({ value, onChange }) =>  {
  const handleChange = (event: SelectChangeEvent<string>) => {
    onChange(event.target.value);
  };
  return (

    <FormControl sx={{ m: 1, minWidth: 140 }} size="small">
      <InputLabel sx={{zIndex:0, marginTop:1}} id="demo-select-small-label">FieldSort</InputLabel>
      <Select
              labelId="demo-simple-select-label"
              id="demo-simple-select"
              value={value}
              label="FieldSort"
              onChange={handleChange}
            >
              <MenuItem value={'ID'}>ID</MenuItem>
              <MenuItem value={'NAME'}>NAME</MenuItem>
              <MenuItem value={'X'}>X</MenuItem>
              <MenuItem value={'Y'}>Y</MenuItem>
              <MenuItem value={'CREATION_DATE'}>CREATION_DATE</MenuItem>
              <MenuItem value={'AREA'}>AREA</MenuItem>
              <MenuItem value={'POPULATION'}>POPULATION</MenuItem>
              <MenuItem value={'METERS_ABOVE_SEA_LEVEL'}>METERS_ABOVE_SEA_LEVEL</MenuItem> 
              <MenuItem value={'ESTABLISHMENT_DATE'}>ESTABLISHMENT_DATE</MenuItem>
              <MenuItem value={'CAPITAL'}>CAPITAL</MenuItem>
              <MenuItem value={'GOVERNMENT'}>ESTABLISHMENT_DATE</MenuItem>
              <MenuItem value={'GOVERNOR'}>CAPITAL</MenuItem>
            </Select>
    </FormControl>
  );
}
export default SelectSort;
