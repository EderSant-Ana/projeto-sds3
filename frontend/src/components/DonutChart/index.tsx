import axios from "axios";
import Chart from "react-apexcharts"
import { BASE_URL } from 'utils/requests'
import { SaleSum } from 'types/sale'

type ChartData = {
    labels: string[];
    series: number[]
}

const DonutChart = () => {
  
    //const mockData = {
    //    series: [477138, 499928, 444867, 220426, 473088],
    //    labels: ['Anakin', 'Barry Allen', 'Kal-El', 'Logan', 'Padmé']
    //}

    let ChartData : ChartData = { labels : [], series: []};

    //FORMA ERRADA
    axios.get(`${BASE_URL}/sales/amount-by-seller`)
        .then((response => {
            const data = response.data as SaleSum[];
            const myLabels = data.map(x => x.sellerName);
            const mySeries = data.map(x => x.sum);    
            ChartData = {labels: myLabels, series: mySeries};    
            console.log(ChartData);
        }))
    
    const options = {
        legend: {
            show: true
        }
    }

    return (
        <Chart 
            options={{ ...options, labels: ChartData.labels}}
            series={ChartData.series}
            type="donut"
            height="240"
        />
    );
}

export default DonutChart;
