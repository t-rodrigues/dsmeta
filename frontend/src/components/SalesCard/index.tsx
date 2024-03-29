import { useEffect, useState } from 'react'
import DatePicker from 'react-datepicker'

import { NotificationButton } from '@/components/NofiticationButton'

import './styles.css'
import 'react-datepicker/dist/react-datepicker.css'

export function SalesCard() {
  const [minDate, setMinDate] = useState(new Date(new Date().setDate(new Date().getDate() - 365)))
  const [maxDate, setMaxDate] = useState(new Date())

  useEffect(() => {
    fetch("http://localhost:8080/api/v1/sales")
      .then(response => response.json())
      .then(json => console.log(json))
  }, [])

  return (
    <div className='dsmeta-card'>
      <h2 className='dsmeta-sales-title'>Vendas</h2>

      <div>
        <div className='dsmeta-form-control-container'>
          <DatePicker
            selected={minDate}
            onChange={(date: Date) => setMinDate(date)}
            className='dsmeta-form-control'
            dateFormat='dd/MM/yyyy'
          />
        </div>
        <div className='dsmeta-form-control-container'>
          <DatePicker
            selected={maxDate}
            onChange={(date: Date) => setMaxDate(date)}
            className='dsmeta-form-control'
            dateFormat='dd/MM/yyyy'
          />
        </div>
      </div>

      <div>
        <table className='dsmeta-sales-table'>
          <thead>
            <tr>
              <th className='show992'>ID</th>
              <th className='show576'>Data</th>
              <th>Vendedor</th>
              <th className='show992'>Visitas</th>
              <th className='show992'>Vendas</th>
              <th>Total</th>
              <th>Notificar</th>
            </tr>
          </thead>

          <tbody>
            <tr>
              <td className='show992'>#341</td>
              <td className='show576'>11/07/2022</td>
              <td>Anakin</td>
              <td className='show992'>15</td>
              <td className='show992'>11</td>
              <td>R$ 55300.00</td>
              <td>
                <div className='dsmeta-red-btn-container'>
                  <NotificationButton />
                </div>
              </td>
            </tr>
          </tbody>
        </table>
      </div>

    </div>
  )
}
