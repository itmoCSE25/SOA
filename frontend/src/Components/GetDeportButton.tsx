import * as React from 'react';
import Button from '@mui/material/Button';
import Stack from '@mui/material/Stack';

interface ButtonsProps {
  inputFrom: string;
  inputTo: string;

}

const GetDeportButton: React.FC<ButtonsProps> = ({ inputFrom, inputTo}) => {
  const handleButtonClick = async () => {
    try {
      const response = await fetch(`https://localhost:8383/genocide-service/genocide/deport/${inputFrom}/${inputTo}`);
      if (!response.ok) {
        throw new Error('Network response was not ok');
      }
    } catch (error) {
      console.error('Error fetching city data:', error);
    }
  };


  return (
    <Stack sx={{marginTop:2}} direction="row" spacing={2}>
      <Button variant="outlined" onClick={handleButtonClick}>Депортировать</Button>
    </Stack>
  );
}
export default GetDeportButton;

