
import * as React from 'react';
import InputLabel from '@mui/material/InputLabel';
import MenuItem from '@mui/material/MenuItem';
import FormControl from '@mui/material/FormControl';
import Select, { SelectChangeEvent } from '@mui/material/Select';


interface Props {
  value: string;
  onChange: (value: string) => void;
}

const SelectTypeFilter: React.FC<Props> = ({ value, onChange }) =>  {
  const handleChange = (event: SelectChangeEvent<string>) => {
    onChange(event.target.value);
  };
  return (

    <FormControl sx={{ m: 1, minWidth: 140 }} size="small">
      <InputLabel sx={{zIndex:0, marginTop:1}} id="demo-select-small-label">TypeFilter</InputLabel>
      <Select
              labelId="demo-simple-select-label"
              id="demo-simple-select"
              value={value}
              label="TypeFilter"
              onChange={handleChange}
            >
              <MenuItem value={'MORE'.toLowerCase()}>MORE</MenuItem>
              <MenuItem value={'moreOrEquals'}>MORE_OR_EQUALS</MenuItem>
              <MenuItem value={'LESS'.toLowerCase()}>LESS</MenuItem>
              <MenuItem value={'lessOrEquals'.toLowerCase()}>LESS_OR_EQUALS</MenuItem>
              <MenuItem value={'EQUALS'.toLowerCase()}>EQUALS</MenuItem>
            </Select>
    </FormControl>
  );
}
export default SelectTypeFilter;
