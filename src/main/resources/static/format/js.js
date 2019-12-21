var Chart = new Chart(document.getElementById("myChart"), {
    type: 'pie',
    // The data for our dataset
    data: {
        labels: ['1', '2', '3'],
        datasets: [{
            label: 'My First dataset',
            backgroundColor: 'rgb(101,195,255)',
            borderColor: 'rgb(255,16,19)',
            data: [5, 10, 5]
        }]
    },

    // Configuration options go here
    options: {}
});