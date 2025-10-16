const snowContainer = document.querySelector('.snow');
const snowflakes = 60;

for (let i = 0; i < snowflakes; i++) {
    const flake = document.createElement('div');
    flake.classList.add('flake');
    flake.style.left = `${Math.random() * 100}%`;
    flake.style.animationDuration = `${5 + Math.random() * 10}s`;
    flake.style.opacity = Math.random();
    flake.style.width = flake.style.height = `${2 + Math.random() * 4}px`;
    snowContainer.appendChild(flake);
}

const style = document.createElement('style');
style.textContent = `
    .flake {
        position: absolute;
        top: -10px;
        background: #ffffff;
        border-radius: 50%;
        animation: fall linear infinite;
    }
    @keyframes fall {
        to {
            transform: translateY(100vh);
        }
    }
`;
document.head.appendChild(style);
