import * as React from 'react';
import Button from '@mui/material/Button';
import Stack from '@mui/material/Stack';

interface ButtonsProps {
  inputValue: string;
}

const GetKillButton: React.FC<ButtonsProps> = ({ inputValue}) => {
  const handleButtonClick = async () => {
    try {
      const response = await fetch(`http://localhost:9990/genocide/kill/${inputValue}`);
      if (!response.ok) {
        throw new Error('Network response was not ok');
      }
    } catch (error) {
      console.error('Error fetching city data:', error);
    }
  };

  return (
    <Stack sx={{marginTop:2}} direction="row" spacing={2}>
      <Button variant="outlined" onClick={handleButtonClick}>Уничтожить</Button>
    </Stack>
  );
}
export default GetKillButton;

