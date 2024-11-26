import * as React from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';

interface InputProps {
  text: string
  value: string;
  onInputChange: (value: string) => void;
  type: 'int' | 'float' | 'string';

}

const Input: React.FC<InputProps> = ({ text, value, onInputChange, type }) => {
  const validateInput = (input: string): boolean => {
    if (type === 'float') {
      if (text === 'Area'){
        return /^\d*[.]?\d*$/.test(input); 
      }
      return /^-?\d*[.]?\d*$/.test(input); 
    }
    if (type === 'int') {
      if (text === 'ID' || text === 'From'|| text === 'To' || text === 'Population'){
        return /^\d*$/.test(input);
      }
      return /^-?\d*$/.test(input); 
    }
    
    return true; 
  };
  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    const inputValue = e.target.value;
    if (validateInput(inputValue)) {
      onInputChange(inputValue); 
    }
  };

  return (
    <Box
      component="form"
      sx={{ '& .MuiTextField-root': { m: 1, width: '10ch' } }}
      noValidate
      autoComplete="off"
    >
      <div>
      <TextField 
        id="standard-basic" 
        label={text} 
        variant="standard" 
        value={value}
        onChange={handleChange}/>
      </div>
    </Box>
  );
}
export default Input;