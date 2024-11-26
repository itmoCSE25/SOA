import * as React from 'react';
import InputLabel from '@mui/material/InputLabel';
import MenuItem from '@mui/material/MenuItem';
import FormControl from '@mui/material/FormControl';
import Select, { SelectChangeEvent } from '@mui/material/Select';


interface Props {
  value: string;
  onChange: (value: string) => void;
}

const Selects: React.FC<Props> = ({ value, onChange }) =>  {
  const handleChange = (event: SelectChangeEvent<string>) => {
    onChange(event.target.value);
  };
  return (

    <FormControl sx={{ m: 1, minWidth: 140 }} size="small">
      <InputLabel sx={{zIndex:0}} id="demo-select-small-label">Government</InputLabel>
      <Select
              labelId="demo-simple-select-label"
              id="demo-simple-select"
              value={value}
              label="Government"
              onChange={handleChange}
            >
              <MenuItem value={'DESPOTISM'}>DESPOTISM</MenuItem>
              <MenuItem value={'PATRIARCHY'}>PATRIARCHY</MenuItem>
              <MenuItem value={'ETHNOCRACY'}>ETHNOCRACY</MenuItem>
            </Select>
    </FormControl>
  );
}
export default Selects;
