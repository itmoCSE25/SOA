import * as React from 'react';
import InputLabel from '@mui/material/InputLabel';
import MenuItem from '@mui/material/MenuItem';
import FormControl from '@mui/material/FormControl';
import Select, { SelectChangeEvent } from '@mui/material/Select';


interface Props {
  value: string;
  onChange: (value: string) => void;
}

const SelectFieldFilter: React.FC<Props> = ({ value, onChange }) =>  {
  const handleChange = (event: SelectChangeEvent<string>) => {
    onChange(event.target.value);
  };
  return (

    <FormControl sx={{ m: 1, minWidth: 140 }} size="small">
      <InputLabel sx={{zIndex:0, marginTop:1}} id="demo-select-small-label">FieldFilter</InputLabel>
      <Select
              labelId="demo-simple-select-label"
              id="demo-simple-select"
              value={value}
              label="FieldFilter"
              onChange={handleChange}
            >
              <MenuItem value={'ID'.toLowerCase()}>ID</MenuItem>
              <MenuItem value={'name'}>NAME</MenuItem>
              <MenuItem value={'X'.toLowerCase()}>X</MenuItem>
              <MenuItem value={'Y'.toLowerCase()}>Y</MenuItem>
              <MenuItem value={'CREATION_DATE'.toLowerCase()}>CREATION_DATE</MenuItem>
              <MenuItem value={'AREA'.toLowerCase()}>AREA</MenuItem>
              <MenuItem value={'POPULATION'.toLowerCase()}>POPULATION</MenuItem>
              <MenuItem value={'METERS_ABOVE_SEA_LEVEL'.toLowerCase()}>METERS_ABOVE_SEA_LEVEL</MenuItem> 
              <MenuItem value={'ESTABLISHMENT_DATE'.toLowerCase()}>ESTABLISHMENT_DATE</MenuItem>
              <MenuItem value={'CAPITAL'.toLowerCase()}>CAPITAL</MenuItem>
              <MenuItem value={'GOVERNMENT'.toLowerCase()}>ESTABLISHMENT_DATE</MenuItem>
              <MenuItem value={'GOVERNOR'.toLowerCase()}>CAPITAL</MenuItem>
            </Select>
    </FormControl>
  );
}
export default SelectFieldFilter;
