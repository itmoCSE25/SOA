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
              <MenuItem value={'id'}>ID</MenuItem>
              <MenuItem value={'name'}>NAME</MenuItem>
              <MenuItem value={'x'}>X</MenuItem>
              <MenuItem value={'y'}>Y</MenuItem>
              <MenuItem value={'creation_date'}>CREATION_DATE</MenuItem>
              <MenuItem value={'area'}>AREA</MenuItem>
              <MenuItem value={'population'}>POPULATION</MenuItem>
              <MenuItem value={'METERS_ABOVE_SEA_LEVEL'.toLowerCase()}>METERS_ABOVE_SEA_LEVEL</MenuItem> 
              <MenuItem value={'ESTABLISHMENT_DATE'.toLowerCase()}>ESTABLISHMENT_DATE</MenuItem>
              <MenuItem value={'CAPITAL'.toLowerCase()}>CAPITAL</MenuItem>
              <MenuItem value={'GOVERNMENT'.toLowerCase()}>ESTABLISHMENT_DATE</MenuItem>
              <MenuItem value={'GOVERNOR'.toLowerCase()}>CAPITAL</MenuItem>
            </Select>
    </FormControl>
  );
}
export default SelectSort;
