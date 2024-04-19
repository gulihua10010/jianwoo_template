import request from '@/utils/request'

// 查询项目状态列表
export function listProjectStatus(query) {
  return request({
    url: '/system/projectStatus/list',
    method: 'get',
    params: query
  })
}

// 查询项目状态详细
export function getProjectStatus(id) {
  return request({
    url: '/system/projectStatus/' + id,
    method: 'get'
  })
}

// 新增项目状态
export function addProjectStatus(data) {
  return request({
    url: '/system/projectStatus',
    method: 'post',
    data: data
  })
}

// 修改项目状态
export function updateProjectStatus(data) {
  return request({
    url: '/system/projectStatus',
    method: 'put',
    data: data
  })
}

// 删除项目状态
export function delProjectStatus(id) {
  return request({
    url: '/system/projectStatus/' + id,
    method: 'delete'
  })
}
