import logo from '@/assets/images/logo.svg'

import './styles.css'

export function Header() {
  return (
    <header>
      <div className='dsmeta-logo-container'>
        <img src={logo} alt='DS Meta' />
        <h1>DSMeta</h1>
        <p>
          Desenvolvido por <a href='https://github.com/t-rodrigues' target='_blank' rel='noopener noreferrer'>@trodrigues.dev</a>
        </p>
      </div>
    </header>
  )
}
