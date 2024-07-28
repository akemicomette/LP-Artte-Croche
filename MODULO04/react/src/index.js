import React from "react";
import { creatRoot } from 'react-dom/client';
import App from './src/app.js';

const container = document.getElementById('root');
const root = creatRoot(container);
root.render(<App/>);