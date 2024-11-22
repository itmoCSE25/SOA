import * as React from 'react';
import dayjs from 'dayjs';
import { DemoContainer, DemoItem } from '@mui/x-date-pickers/internals/demo';
import { AdapterDayjs } from '@mui/x-date-pickers/AdapterDayjs';
import { LocalizationProvider } from '@mui/x-date-pickers/LocalizationProvider';
import { DesktopDatePicker } from '@mui/x-date-pickers/DesktopDatePicker';

interface InputProps {
  text: string;
  value: dayjs.Dayjs;
  onInputChange: (value: Date) => void;
}

const DateInputs: React.FC<InputProps> = ({ text, value, onInputChange }) => {
  const handleChange = (date: dayjs.Dayjs | null) => {
    if (date === null) {
      onInputChange(new Date(0)); // Обработка случая, когда date равен null
    } else {
      onInputChange(date.toDate()); // Преобразование Dayjs в Date
    };
  };

  return (
    <LocalizationProvider dateAdapter={AdapterDayjs}>
      <DemoContainer components={['DesktopDatePicker']}>
        <DemoItem label={text}>
          <DesktopDatePicker value={value} onChange={handleChange} />
        </DemoItem>
      </DemoContainer>
    </LocalizationProvider>
  );
};

export default DateInputs;
