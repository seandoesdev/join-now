var calendar = null;

$(document).ready(function() {
	var calendarEl = document.getElementById('calendar');

	var calendar = new FullCalendar.Calendar(calendarEl, {
		headerToolbar : {
			start : 'dayGridMonth,dayGridWeek,dayGridDay today',
			center : 'title',
			end : 'prev,next',
		},
		footerToolbar : {
			start : '',
			center : '',
			end : ''
		},
		firstDay: 1,
		titleFormat: function (date) {
		year = date.date.year;
        month = date.date.month + 1;

		return year + "년 " + month + "월";
		},

		navLinks : true, // can click day/week names to navigate views
		editable : true,
		dayMaxEvents : true, // allow "more" link when too many events
		selectable : true, // 마우스로 선택한 날짜 클릭 시 색상 변환
		locale : 'ko', // 한국어 적용
		selectMirror : true,
		height : 30,
		contentHeight : 'auto', // 일정개수에 맞게 달력 크기 조절
		eventAdd : function() {// 이벤트가 추가되면 발생하는 이벤트
			console.log()
		},
		
		events : [],
		
		select : function(info) {
			console.log(info);

			$("#backDropModal").modal("show"); // modal 나타내기

			$("#event_start_date").val(info.startStr);
			$("#event_end_date").val(info.endStr);

			$("#addEvent").on("click", function() {
				let event = {
					title : $("#eventContent").val(),
					startDate : info.startStr,
					endDate : info.endStr,
					color : $("#event_color").val()
				};

				// 일정 검증
				if (event.title == null || event.title == "") {
					alert("내용을 입력하세요.");
				} else if (new Date(event.endDate) - new Date(event.startDate) < 0) {
					alert("종료일이 시작일보다 먼저입니다.");
				} else if (event.color == null || event.color == "") {
					alert("색상을 선택해주세요.");
				} else {

					$("#backDropModal").modal("hide");
					
					// 서버로 데이터 전송
			        $.ajax({
			            type: 'POST',
			            url: './insertSch',
			            data: JSON.stringify(event),
			            contentType: 'application/json; charset=utf-8',
			            success: function(response) {
//			                console.log('데이터 전송 성공. 서버 응답: ' + response);
			                console.log('데이터 전송 성공. 서버 응답: ');
			            	
			            },
			            error: function(xhr, status, error) {
			                console.error('데이터 전송 실패. 에러: ' + error);
			            }
			        });
				}

				console.log(calendar.getEvents());

			});
			
			// eventChange: function (obj) { // 이벤트가 수정되면 발생하는 이벤트
			// allEvent = calendar.getEvents();
			// console.log(allEvent);
			// },
			// eventRemove: function (obj) { // 이벤트가 삭제되면 발생하는 이벤트
			// console.log(obj);
			// },

		},

		dateClick : function(info) {
			console.log("Clicked event occurs : date = " + info);
			
		}

	});

	calendar.render();

});
