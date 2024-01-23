def solution(num_list):
    if num_list[-1] > num_list[-2]:  # 마지막 원소가 그전 원소보다 크다면
        num_list.append(num_list[-1] - num_list[-2])  # 마지막 원소에서 그전 원소를 뺀 값을 추가
    else:  # 마지막 원소가 그전 원소보다 크지 않다면
        num_list.append(num_list[-1] * 2)  # 마지막 원소를 두 배한 값을 추가
    return num_list