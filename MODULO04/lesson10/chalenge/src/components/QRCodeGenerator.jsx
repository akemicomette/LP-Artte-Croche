import { useState } from 'react';
import styled from 'styled-components';
import QRCode from 'qrcode.react';

const Container = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  padding: 40px;
  background: #fff;
  border-radius: 15px;
  box-shadow: 0 6px 12px rgba(0, 0, 0, 0.2);
  max-width: 800px;
  margin: 50px auto;
`
const Title = styled.h2`
  color: #333;
  margin-bottom: 20px;
  font-size: 24px;
  text-align: center;
`
const Input = styled.input`
  margin-bottom: 20px;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 5px;
  width: 100%;
  box-shadow: inset 0 2px 4px rgba(0, 0, 0, 0.1);
  font-size: 16px;
  transition: border-color 0.3s;

  &:focus {
    border-color: #007bff;
    outline: none;
  }
`

const QRCodeGenerator = () => {


  return (
    <Container>
      <Title>QR Code Generator</Title>
      <Input
      type="text"
      value={query} 
      onChange={(e) => setQuery(e.target.value)} 
      placeholder="Digite texto para conversão" />

      <QRContainer></QRContainer>
    </Container>
  )
}

export default QRCodeGenerator