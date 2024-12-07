import * as React from 'react';
import InputLabel from '@mui/material/InputLabel';
import MenuItem from '@mui/material/MenuItem';
import FormControl from '@mui/material/FormControl';
import Select, { SelectChangeEvent } from '@mui/material/Select';


interface Props {
  value: string;
  onChange: (value: string) => void;
}

const SelectTypeSort: React.FC<Props> = ({ value, onChange }) =>  {
  const handleChange = (event: SelectChangeEvent<string>) => {
    onChange(event.target.value);
  };
  return (

    <FormControl sx={{ m: 1, minWidth: 140 }} size="small">
      <InputLabel sx={{zIndex:0, marginTop:1}} id="demo-select-small-label">TypeSort</InputLabel>
      <Select
              labelId="demo-simple-select-label"
              id="demo-simple-select"
              value={value}
              label="TypeSort"
              onChange={handleChange}
            >
              <MenuItem value={'ASC'.toLowerCase()}>ASC</MenuItem>
              <MenuItem value={'DESC'.toLowerCase()}>DESC</MenuItem>
            </Select>
    </FormControl>
  );
}
export default SelectTypeSort;
