import { Component, OnInit } from '@angular/core';
import {Chart} from 'chart.js';
import { ServletService } from '../servlet.service';


@Component({
  selector: 'app-adminchart',
  templateUrl: './adminchart.component.html',
  styleUrls: ['./adminchart.component.css']
})
export class AdminchartComponent implements OnInit {

  
//    Activate=[];
//    Deactivate=[];
//    Total_Task=[]; 
    myChart=[];

  constructor(private sc:ServletService) { }

  tempChart:any;
  ngOnInit() {
        this.sc.ViewChart().subscribe((res)=>{
            console.log(JSON.stringify(res))
            this.tempChart=res;

            this.myChart = new Chart('canvas', {
                type: 'bar',
                data: {
                    labels: ['New User','Active User','Total Task'],
                    datasets: [{
                        label: 'In Last 7 Days',
                        data: [this.tempChart.newUser,this.tempChart.activeUser,this.tempChart.totalTask],
                        backgroundColor: [
                            'rgba(255, 99, 132, 0.2)',
                            'rgba(54, 162, 235, 0.2)',
                            'rgba(255, 206, 86, 0.2)',
                            'rgba(75, 192, 192, 0.2)',
                            'rgba(153, 102, 255, 0.2)',
                            'rgba(255, 159, 64, 0.2)'
                        ],
                        borderColor: [
                            'rgba(255, 99, 132, 1)',
                            'rgba(54, 162, 235, 1)',
                            'rgba(255, 206, 86, 1)',
                            'rgba(75, 192, 192, 1)',
                            'rgba(153, 102, 255, 1)',
                            'rgba(255, 159, 64, 1)'
                        ],
                        borderWidth: 1
                    }]
                },
                options: {
                    scales: {
                        yAxes: [{
                            ticks: {
                                beginAtZero: true
                            }
                        }]
                    }
                }
            });
           
        
        });
    
       
  }

}